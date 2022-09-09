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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Facility;
import beans.Training;
import dao.FacilityDao;
import dao.TrainingDao;
import dto.FacilityDto;
import dto.SearchDto;
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
	
	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public String EditTraining(Training tr){
		List<Training> trainingList = new ArrayList<Training>();
		trainingList = trainingDao.getByFacilityId(tr.getFacilityId());
		
		if (!trainingList.stream().anyMatch(t -> t.getName().equals(tr.getName()) &&  t.getId()!=tr.getId())) {
			trainingDao.EditTraining(tr);
			return "uspesno";
			
		}
		
		return "ima";
		
	}
	
	@GET
	@Path("{since}/searchPrice/{to}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Training> search(@PathParam("since") int since,@PathParam("to") int to) {
		
		if(to == 0) {
			
		 return getAll().stream().filter(t -> t.getPrice()  >= since )
					.collect(Collectors.toList());
			
		}
		
		 return getAll().stream().filter(t -> t.getPrice()>=since &&  t.getPrice()<=to)
					.collect(Collectors.toList());
					
	}
	
	@GET
	@Path("/searchFree")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Training> search() {
		
			
		 return getAll().stream().filter(t -> t.getPrice()  == 0 )
					.collect(Collectors.toList());
			
		
					
	}
	
	
	
}
