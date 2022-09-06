package service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Facility;
import beans.Training;
import dao.FacilityDao;
import dao.TrainingDao;
import dto.FacilityDto;
import main.App;

@Path("/trainings")
public class TrainingService {

	@Context
	private ServletContext ctx;

	private TrainingDao trainingDao;


	
	
	
	@PostConstruct
	public void init() {
		this.trainingDao = (TrainingDao) ctx.getAttribute(App.TRAINING_DAO);
	}
	
	
	@POST
	@Path("/update")
	public void update() {
		trainingDao.updateFile();
		
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Training> getAll() {
		
		return trainingDao.getAll().stream().filter(Training::isNotDeleted).map(f -> new Training(f))
				.collect(Collectors.toList());

	}
	
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Training> getByID(@PathParam("id") int id) {
		List<Training> l = getAll();
		return l.stream().filter(t -> t.getFacilityId() == id)
				.collect(Collectors.toList());
	}
	
	
	
}
