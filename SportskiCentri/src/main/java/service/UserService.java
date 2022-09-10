package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Facility;
import beans.Manager;
import beans.Trainer;
import beans.User;
import dao.AdminDao;
import dao.BuyerDao;
import dao.FacilityDao;
import dao.ManagerDao;
import dao.TrainerDao;
import dto.FacilityDto;
import javassist.expr.NewArray;
import main.App;

@Path("/users")
public class UserService {
	
	@Context
	private ServletContext ctx;
	
	private ManagerDao managerDao;
	private AdminDao adminDao;
	private BuyerDao buyerDao;
	private TrainerDao trainerDao;
	
	
	@PostConstruct
	public void init() {
		this.managerDao = (ManagerDao) ctx.getAttribute(App.MANAGER_DAO);
		this.trainerDao = (TrainerDao) ctx.getAttribute(App.TRAINER_DAO);
		this.adminDao = (AdminDao) ctx.getAttribute(App.ADMIN_DAO);
		this.buyerDao = (BuyerDao) ctx.getAttribute(App.BUYER_DAO);
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll() {
		System.out.println("//////////////////////////////////////////////////////////////////////");
		List<User> buyerlist =buyerDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList());
		List<User> adminlist =adminDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList());
		List<User> managerlist =managerDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList());
		List<User> trainerlist =trainerDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList());
		
		
		
		List<User> userList= new ArrayList<User>();
		userList = buyerlist;
		userList.addAll(managerlist);
		userList.addAll(adminlist);
		userList.addAll(trainerlist);
		
	
		
		/*	List<User> userlist =managerDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList());
		userlist.addAll(adminDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList()));
		userlist.addAll(buyerDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList()));
		userlist.addAll(trainerDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList()));
		System.out.println(userlist.size());
		
		*/
		return userList;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
