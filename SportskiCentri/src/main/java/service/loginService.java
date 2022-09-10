package service;

import javax.ws.rs.core.MediaType;
import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import dao.AdminDao;
import dao.BuyerDao;
import dao.FacilityDao;
import dao.ManagerDao;
import dao.TrainerDao;
import dto.UserLoginDto;
import main.App;

@Path("/login")
public class loginService {
	
	
	
	@Context
	ServletContext ctx;
	
	FacilityDao facilityDao;
	BuyerDao buyerDao;
	TrainerDao trainerDao;
	ManagerDao managerDao;
	AdminDao adminDao;
	
	public loginService() {
	}
	
	
	
	@PostConstruct
	public void init() {
		this.facilityDao = (FacilityDao) ctx.getAttribute(App.FACILITY_DAO);
		this.buyerDao = (BuyerDao) ctx.getAttribute(App.BUYER_DAO);
		this.trainerDao = (TrainerDao) ctx.getAttribute(App.TRAINER_DAO);
		this.managerDao = (ManagerDao) ctx.getAttribute(App.MANAGER_DAO);
		this.adminDao = (AdminDao) ctx.getAttribute(App.ADMIN_DAO);
		
		
	}

	
	
	public static String path;

	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String  Login(UserLoginDto user) {
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		
		String buyer = buyerDao.loginBuyer(user);
		System.out.println();
		System.out.println(buyer+ "Faca ti je sranje");
		if(buyer=="not") {
			
			String trainer = trainerDao.loginTrainer(user);
			if(trainer=="not") {
				
				String manager = managerDao.loginManager(user);
				if(manager=="not") {
					String admin = adminDao.loginAdmin(user);
					return admin;
				}else {
					return manager;
				}
				
					
			}else {
				return trainer;
			}
				
		}else {
			return buyer;
		}
		


	}
	
	
	
	
	
	

}

	


