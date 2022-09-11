package service;

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

import beans.Admin;
import beans.Trainer;
import beans.Training;
import dao.AdminDao;
import dao.BuyerDao;
import dao.ManagerDao;
import dao.TrainerDao;
import dto.UserDto;
import dto.UserEditDto;
import main.App;

@Path("/admins")
public class AdminService {
	
	
	private ManagerDao managerDao;
	private AdminDao adminDao;
	private BuyerDao buyerDao;
	private TrainerDao trainerDao;
	
	@Context
	private ServletContext ctx;
	
	@PostConstruct
	public void init() {
		this.managerDao = (ManagerDao) ctx.getAttribute(App.MANAGER_DAO);
		this.trainerDao = (TrainerDao) ctx.getAttribute(App.TRAINER_DAO);
		this.adminDao = (AdminDao) ctx.getAttribute(App.ADMIN_DAO);
		this.buyerDao = (BuyerDao) ctx.getAttribute(App.BUYER_DAO);

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Admin> getAll() {
		return adminDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList());
	}
	
	@GET
	@Path("/logedAdmin")
	@Produces(MediaType.APPLICATION_JSON)
	public UserEditDto getAllLogedAdmin() {
		Admin a =  adminDao.getLogAdmin();
		UserEditDto  userEdit= new UserEditDto(a);
		return userEdit;
	
	}
	
	
	
	
	
	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public String EditAdmin(UserDto a) {	
		String username = a.getUsername();
		if(adminDao.DoesContainUsernameExecptLogged(username) || buyerDao.DoesContainUsername(username)|| managerDao.DoesContainUsername(username) || trainerDao.DoesContainUsername(username)) {
			return "ima";
		}
		
		Admin ad = new Admin(a);
		
		adminDao.Edit(ad);
		return "uspesno";
		
	}
	
}
