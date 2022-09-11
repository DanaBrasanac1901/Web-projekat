package service;

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

import beans.Admin;
import beans.Buyer;
import beans.Facility;
import beans.Manager;
import dao.AdminDao;
import dao.BuyerDao;
import dao.FacilityDao;
import dao.ManagerDao;
import dao.TrainerDao;
import dto.FacilityDto;
import dto.ManagerEditDto;
import dto.RegisterUserDto;
import dto.UserDto;
import dto.UserEditDto;
import main.App;

@Path("/managers")

public class ManagerService {

	private ManagerDao managerDao;
	private AdminDao adminDao;
	private BuyerDao buyerDao;
	private TrainerDao trainerDao;
	private FacilityDao facilityDao;
	
	@Context
	private ServletContext ctx;
	
	@PostConstruct
	public void init() {
		this.managerDao = (ManagerDao) ctx.getAttribute(App.MANAGER_DAO);
		this.trainerDao = (TrainerDao) ctx.getAttribute(App.TRAINER_DAO);
		this.adminDao = (AdminDao) ctx.getAttribute(App.ADMIN_DAO);
		this.buyerDao = (BuyerDao) ctx.getAttribute(App.BUYER_DAO);
		this.facilityDao = (FacilityDao) ctx.getAttribute(App.FACILITY_DAO);

	}
	
	@GET
	@Path("/logedManager")
	@Produces(MediaType.APPLICATION_JSON)
	public ManagerEditDto getAllLogedManager() {
		Manager a =  managerDao.getLogManager();
		ManagerEditDto userEdit= new ManagerEditDto(a);
		return userEdit;
	
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Manager> getAll() {
		return managerDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList());
	}
	
	
	@GET
	@Path("/free")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Manager> getAllWithoutFacility() {
		
		return managerDao.getAll().stream().filter(t -> (t.getFacility() == 0 ))
				.collect(Collectors.toList());
	}
	
	@POST
	@Path("/{username}")
	public void SetFacility(@PathParam("username") String username) {
		int id = facilityDao.makeNewKey() -1;
		managerDao.SetFacility(id, username);
	}
	
	@GET
	@Path("/getFacilitie")
	public int GetFacility() {
		return managerDao.GetFacility();
	}
	
	
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String RegisterNew(RegisterUserDto userInfo) {
		String username = userInfo.getUsername();
		if(adminDao.DoesContainUsername(username) || buyerDao.DoesContainUsername(username)|| managerDao.DoesContainUsername(username)|| trainerDao.DoesContainUsername(username)) {
			return "ima";
		}
		
		Manager newManager = new Manager(userInfo.getUsername(), userInfo.getPassword(), userInfo.getFirstName(),
		userInfo.getLastName(), userInfo.getGender(), userInfo.getBirthDate());
		return managerDao.RegisterNew(newManager);

	}
	
	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public String EditManager(UserDto a) {	
		String username = a.getUsername();
		if(managerDao.DoesContainUsernameExecptLogged(username) || buyerDao.DoesContainUsername(username)|| adminDao.DoesContainUsername(username)|| trainerDao.DoesContainUsername(username)) {
			return "ima";
		}
		Manager ad = new Manager(a);
		managerDao.Edit(ad);
	  return "uspesno";
		
	}

	
	
}
