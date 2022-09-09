package service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
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
import beans.Facility;
import beans.HistoryTraining;
import beans.Membership;
import beans.Training;
import dao.BuyerDao;
import dao.FacilityDao;
import dao.MembershipDao;
import dao.TrainingDao;
import dto.FacilityDto;
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
		return buyerDao.getAll().stream().collect(Collectors.toList());
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
	public String createNew(UserDto userInfo) {

		Buyer newBuyer = new Buyer(userInfo.getUsername(), userInfo.getPassword(), userInfo.getFirstName(),
				userInfo.getLastName(), userInfo.getGender(), userInfo.getBirthDate());
		return buyerDao.addNew(newBuyer);

	}

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
	public List<MembershipDto> getAllMemberships(){
		
		return membershipDao.getAll().stream().filter(Membership::isNotDeleted).map(m -> new MembershipDto(m))
				.collect(Collectors.toList());
		

		
	}
	
}
