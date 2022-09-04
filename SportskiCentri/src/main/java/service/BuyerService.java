package service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Buyer;
import beans.Facility;
import beans.Gender;
import beans.Role;
import dao.BuyerDao;
import dao.FacilityDao;
import dto.FacilityDto;
import dto.UserDto;
import main.App;


@Path("/buyers")
public class BuyerService {
	private BuyerDao buyerDao;
	
	@Context
	private ServletContext ctx;
	
	
	
	@PostConstruct
	public void init() {
		this.buyerDao = (BuyerDao) ctx.getAttribute(App.BUYER_DAO);

	}
	
	
	
	@POST
	@Path("/autoNew")
	@Produces(MediaType.APPLICATION_JSON)
	public void autoCreateNew() {
		try {
			UserDto user = new UserDto("buyer", "buyer", "Lazar", "Mijatovic", Gender.MALE, (Date) new SimpleDateFormat("dd/MM/yyyy").parse("10/07/1999") );
			createNew(user);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createNew(UserDto userInfo) {
	//	Buyer newBuyer = new Buyer(userInfo.getUsername(),userInfo.getPassword(),userInfo.getFirstName(),userInfo.getLastName(),userInfo.getGender(),userInfo.getBirthDate(),false);
	//	buyerDao.addNew(newBuyer);
		
	}
	
	
	
	

}
