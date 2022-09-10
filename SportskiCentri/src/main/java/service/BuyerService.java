package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Buyer;
import beans.HistoryTraining;
import beans.InstantiatedMembership;
import beans.Membership;
import beans.MembershipType;
import beans.Training;
import dao.BuyerDao;
import dao.FacilityDao;
import dao.MembershipDao;
import dao.TrainingDao;
import dto.MembershipDto;
import dto.RegisterUserDto;
import dto.TrainingDto;
import dto.UserDto;
import main.App;

@Path("/buyers")
public class BuyerService {

	@Context
	private ServletContext ctx;

	private BuyerDao buyerDao;
	private TrainingDao trainingDao;
	private FacilityDao facilityDao;
	private MembershipDao membershipDao;

	@PostConstruct
	public void init() {
		this.buyerDao = (BuyerDao) ctx.getAttribute(App.BUYER_DAO);
		this.trainingDao = (TrainingDao) ctx.getAttribute(App.TRAINING_DAO);
		this.facilityDao = (FacilityDao) ctx.getAttribute(App.FACILITY_DAO);
		this.membershipDao = (MembershipDao) ctx.getAttribute(App.MEMBERSHIP_DAO);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Buyer> getAll() {
			return buyerDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList());

	}

	/*
	 * @POST
	 * 
	 * @Path("/autoNew")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public void autoCreateNew() { try {
	 * UserDto user = new UserDto("buyer", "buyer", "Lazar", "Mijatovic",
	 * Gender.MALE, (Date) new SimpleDateFormat("dd/MM/yyyy").parse("10/07/1999") );
	 * createNew(user);
	 * 
	 * } catch (ParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * }
	 */

	@POST
	@Path("/registration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createNew(RegisterUserDto userInfo) {

		Buyer newBuyer = new Buyer(userInfo.getUsername(), userInfo.getPassword(), userInfo.getFirstName(),
				userInfo.getLastName(), userInfo.getGender(), userInfo.getBirthDate().toLocalDate());
		return buyerDao.addNew(newBuyer);

	}

/*
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String RegisterNew(RegisterUserDto userInfo) {

		Buyer newBuyer = new Buyer(userInfo.getUsername(), userInfo.getPassword(), userInfo.getFirstName(),
		userInfo.getLastName(), userInfo.getGender(), userInfo.getBirthDate().toLocalDate());
		return buyerDao.RegisterNew(newBuyer);

	}
	*/



	// ispravi na samo u poslednjih mesec dana datum bude
	@GET
	@Path("/trainings/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingDto> getTrainingList(@PathParam("username") String buyerUsername) {

		Buyer buyer = buyerDao.getByUsername(buyerUsername);

		List<TrainingDto> trainingDtos = new ArrayList<TrainingDto>();

		List<HistoryTraining> trainingHistory = buyer.getTrainingHistory();
		trainingHistory = trainingHistory.stream().sorted(Comparator.comparingInt(HistoryTraining::getTrainingId))
				.collect(Collectors.toList());

		int currentTrainingId = trainingHistory.get(0).getTrainingId();
		Training currentTraining = trainingDao.getById(currentTrainingId);
		TrainingDto currentTrainingDto = new TrainingDto(currentTraining.getName(),
				facilityDao.getById(currentTraining.getFacilityId()).getName(), null);

		for (int i = 0; i <= trainingHistory.size(); i++) {

			if (currentTrainingId != trainingHistory.get(i).getTrainingId()) {

				trainingDtos.add(currentTrainingDto);
				currentTrainingId = trainingHistory.get(i).getTrainingId();
				currentTrainingDto = new TrainingDto(currentTraining.getName(),
						facilityDao.getById(currentTraining.getFacilityId()).getName(), null);
				currentTrainingDto.addNewDateOfTraining(trainingHistory.get(i).getDate());

			} else {
				currentTrainingDto.addNewDateOfTraining(trainingHistory.get(i).getDate());
			}

		}

		return trainingDtos;
	}

	@GET
	@Path("/all-memberships")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MembershipDto> getAllMemberships() {

		return membershipDao.getAll().stream().filter(Membership::isNotDeleted).map(m -> new MembershipDto(m))
				.collect(Collectors.toList());

	}

	@POST
	@Path("{username}/set-membership-{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void setNewMembership(@PathParam("username") String username, @PathParam("id") String membershipId) {
		Buyer buyer = buyerDao.getByUsername(username);
		Membership membership = membershipDao.getById(membershipId);

		int durationInDays;
		if (membership.getMemType().equals(MembershipType.WEEK)) {
			durationInDays = 7;
		} else if (membership.getMemType().equals(MembershipType.YEAR)) {
			durationInDays = 365;
		} else {
			durationInDays = 30;
		}
		InstantiatedMembership newMembership = new InstantiatedMembership(membershipId, false, LocalDate.now(),
				LocalDate.now().plusDays(durationInDays), membership.getPrice(), buyer, true,
				membership.getNumberOfEntrances());
		buyer.setMembership(newMembership);

	}

	@POST
	@Path("{username}/{picked-facility-id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String havingWorkout(@PathParam("username") String username,
			@PathParam("picked-facility-id") int facilityId) {
		Buyer buyer = buyerDao.getByUsername(username);
		if (buyer.getMembership() == null) {
			return "NEMA CLANARINU";
		}
		if (buyerDao.isMembershipActive(buyer.getMembership())) {
			buyerDao.buyerHavingTraining(buyer);
			if (buyer.getMembership().getNumberOfEntrances() == 0) {
				buyerDao.deactivateMembership(buyer);
				return "POTROSIO SVE ULAZE";

			} else {
				
					return "USPESAN TRENING";	
			}
		}else {
			
			buyerDao.deactivateMembership(buyer);
			return "CLANARINA NE VAZI VISE";
		}

	}

}

/*
 * @POST
 * 
 * @Path("/new")
 * 
 * @Consumes(MediaType.APPLICATION_JSON)
 * 
 * @Produces(MediaType.APPLICATION_JSON) public void createNew(UserDto userInfo)
 * {
 * 
 * Buyer newBuyer = new Buyer(userInfo.getUsername(), userInfo.getPassword(),
 * userInfo.getFirstName(), userInfo.getLastName(), userInfo.getGender(),
 * userInfo.getBirthDate()); buyerDao.addNew(newBuyer);
 * 
 * }
 */
