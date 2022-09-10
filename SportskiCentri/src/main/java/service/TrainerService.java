package service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Manager;
import beans.Trainer;
import dao.FacilityDao;
import dao.ManagerDao;
import dao.TrainerDao;
import main.App;

@Path("/trainers")
public class TrainerService {
	
	private TrainerDao  trainerDao;
	
	@Context
	private ServletContext ctx;
	
	@PostConstruct
	public void init() {
		this.trainerDao = (TrainerDao) ctx.getAttribute(App.TRAINER_DAO);

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Trainer> getAll() {
		return trainerDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList());
	}
	
	
	
	
	
	

}
