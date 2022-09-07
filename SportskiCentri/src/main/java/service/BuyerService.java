package service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
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
import dao.BuyerDao;
import dto.RegisterUserDto;
import dto.UserDto;
import main.App;

@Path("/buyers")
public class BuyerService {

	@Context
	private ServletContext ctx;

	private BuyerDao buyerDao;

	@PostConstruct
	public void init() {
		this.buyerDao = (BuyerDao) ctx.getAttribute(App.BUYER_DAO);

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
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createNew(UserDto userInfo) {
		
		Buyer newBuyer = new Buyer(userInfo.getUsername(), userInfo.getPassword(), userInfo.getFirstName(),
		userInfo.getLastName(), userInfo.getGender(), userInfo.getBirthDate());
		buyerDao.addNew(newBuyer);

	}
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String RegisterNew(RegisterUserDto userInfo) {

		Buyer newBuyer = new Buyer(userInfo.getUsername(), userInfo.getPassword(), userInfo.getFirstName(),
		userInfo.getLastName(), userInfo.getGender(), userInfo.getBirthDate().toLocalDate());
		return buyerDao.RegisterNew(newBuyer);

	}
	
	

}
