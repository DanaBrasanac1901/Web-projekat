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
import beans.Buyer;
import beans.Manager;
import beans.Trainer;
import beans.Training;
import dao.AdminDao;
import dao.BuyerDao;
import dao.FacilityDao;
import dao.ManagerDao;
import dao.TrainerDao;
import dao.TrainingDao;
import dto.UserDto;
import dto.UserEditDto;
import main.App;

@Path("/trainers")
public class TrainerService {
	
	
	private ManagerDao managerDao;
	private AdminDao adminDao;
	private BuyerDao buyerDao;
	private TrainerDao  trainerDao;
	private TrainingDao trainingDao;
	
	@Context
	private ServletContext ctx;
	
	
	
	@PostConstruct
	public void init() {
		this.managerDao = (ManagerDao) ctx.getAttribute(App.MANAGER_DAO);
		this.trainerDao = (TrainerDao) ctx.getAttribute(App.TRAINER_DAO);
		this.adminDao = (AdminDao) ctx.getAttribute(App.ADMIN_DAO);
		this.buyerDao = (BuyerDao) ctx.getAttribute(App.BUYER_DAO);
		this.trainingDao = (TrainingDao) ctx.getAttribute(App.TRAINING_DAO);

	}
	
	
	
	@GET
	@Path("/logedTrainer")
	@Produces(MediaType.APPLICATION_JSON)
	public UserEditDto getAllLogedTrainer() {
		Trainer a =  trainerDao.getLogTrainer();
		UserEditDto  userEdit= new UserEditDto(a);
		return userEdit;
	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Trainer> getAll() {
		return trainerDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList());
	}
	
	
	
	
	@POST
	@Path("/registration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createNew(UserDto userInfo) {
		String username = userInfo.getUsername();
		if(adminDao.DoesContainUsername(username) || buyerDao.DoesContainUsername(username)|| managerDao.DoesContainUsername(username) || trainerDao.DoesContainUsername(username)) {
			return "ima";
		}
		Trainer newTrainer = new Trainer(userInfo.getUsername(), userInfo.getPassword(), userInfo.getFirstName(),
				userInfo.getLastName(), userInfo.getGender(), userInfo.getBirthDate());
		return trainerDao.addNew(newTrainer);

	}
	
	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public String EditTrainer(UserDto a) {	
		String username = a.getUsername();
		if(adminDao.DoesContainUsername(username) || buyerDao.DoesContainUsername(username)|| managerDao.DoesContainUsername(username) || trainerDao.DoesContainUsernameExecptLogged(username)) {
			return "ima";
		}
		
		Trainer ad = new Trainer(a);
		
		trainerDao.Edit(ad);
		return "uspesno";
		
	}
	
	
	@GET
	@Path("/trainersInFacility")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Trainer> getTrainersInFacility() {
		int id = managerDao.GetFacility();
		System.out.println(id);
		List<Training> trainingList = trainingDao.getAll().stream().filter(t -> t.getFacilityId() == id && t.isNotDeleted()).collect(Collectors.toList()); ;
		List<Trainer>  trainerList= new ArrayList(); 
		System.out.println(trainingList.isEmpty());
		for(Training t : trainingList) {
			if(!t.getTrainerUsername().isEmpty()) {
			Trainer trainer = trainerDao.getById(t.getTrainerUsername());
			if(trainer.isNotDeleted()) {
				trainerList.add(trainer);
			}
				
			}
			
		}
		
		return trainerList.stream().distinct().collect(Collectors.toList());
		
	}
	
	
	@GET
	@Path("/trainingsOfTrainer")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Training> gList(){
		String username = trainerDao.getLogTrainer().getUsername();
		List<Training> trainings = trainingDao.getAll().stream().filter(Training::isNotDeleted).map(f -> new Training(f))
				.collect(Collectors.toList());
		List<Training> tr = trainings.stream().filter(t -> t.getTrainerUsername().contentEquals( username) ).collect(Collectors.toList());
		
		System.out.println(tr.size());
		return tr;
		
		
		
	}
	
	
	
	
	
	

}
