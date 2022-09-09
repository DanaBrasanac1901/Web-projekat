package service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Buyer;
import beans.HistoryTraining;
import dao.BuyerDao;
import dao.TrainingDao;
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

	@PostConstruct
	public void init() {
		this.buyerDao = (BuyerDao) ctx.getAttribute(App.BUYER_DAO);
		this.trainingDao = (TrainingDao) ctx.getAttribute(App.TRAINING_DAO);

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
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createNew(UserDto userInfo) {

		Buyer newBuyer = new Buyer(userInfo.getUsername(), userInfo.getPassword(), userInfo.getFirstName(),
				userInfo.getLastName(), userInfo.getGender(), userInfo.getBirthDate());
		return buyerDao.addNew(newBuyer);

	}

	

	@GET
	@Path("/trainings")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingDto> getTrainingList(String buyerUsername) {
		Buyer buyer = buyerDao.getByUsername(buyerUsername);
		List<TrainingDto> trainingDto = new ArrayList<TrainingDto>();
		List<HistoryTraining> trainingHistory = buyer.getTrainingHistory();
		for (int i = 0; i <= trainingHistory.size(); i++) {
			
		}
		return trainingDto;
	}

}
