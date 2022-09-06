package service;

import javax.ws.rs.core.MediaType;
import javax.annotation.PostConstruct;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import beans.User;
import dao.BuyerDao;
import dao.FacilityDao;
import dto.UserLoginDto;
import main.App;
import dto.UserLoginDto;

@Path("/login")
public class loginService {
	
	
	
	@Context
	ServletContext ctx;
	
	FacilityDao facilityDao;
	BuyerDao buyerDao;
	
	

	public loginService() {
	}
	
	
	
	@PostConstruct
	public void init() {
		this.facilityDao = (FacilityDao) ctx.getAttribute(App.FACILITY_DAO);
		this.buyerDao = (BuyerDao) ctx.getAttribute(App.BUYER_DAO);

	}

	
	
	public static String path;
	
	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String  Login(UserLoginDto user) {
		String buyer = buyerDao.loginBuyer(user);
		int i =buyerDao.getAll().size();
		return buyer;
		
	}
	
	
	  public String Login(String username ,String password) {
		BuyerDao buyerDao = (BuyerDao)ctx.getAttribute("buyerDao");
		//String buyer = buyerDao.loginBuyer(username,password);
		//if(buyer!="not") {return "not";}
		
				
		
		
		return "not";
	}
	 
	
	

}

	


