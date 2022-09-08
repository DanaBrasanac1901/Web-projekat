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

import beans.Buyer;
import beans.Facility;
import beans.Manager;
import dao.BuyerDao;
import dao.FacilityDao;
import dao.ManagerDao;
import dto.FacilityDto;
import dto.RegisterUserDto;
import main.App;

@Path("/managers")

public class ManagerService {

	
	private ManagerDao managerDao;
	private FacilityDao facilityDao;
	
	@Context
	private ServletContext ctx;
	
	@PostConstruct
	public void init() {
		this.managerDao = (ManagerDao) ctx.getAttribute(App.MANAGER_DAO);
		this.facilityDao = (FacilityDao) ctx.getAttribute(App.FACILITY_DAO);

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Manager> getAll() {
		return managerDao.getAll().stream().collect(Collectors.toList());
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
	public void SetFacility(@PathParam("username") String username ) {
		int id = facilityDao.makeNewKey();
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

		Manager newManager = new Manager(userInfo.getUsername(), userInfo.getPassword(), userInfo.getFirstName(),
		userInfo.getLastName(), userInfo.getGender(), userInfo.getBirthDate().toLocalDate());
		return managerDao.RegisterNew(newManager);

	}

	
	
}
