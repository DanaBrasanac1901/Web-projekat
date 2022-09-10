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
import dao.TrainerDao;
import main.App;

@Path("/admins")
public class AdminService {
	
	
	private AdminDao adminDao;
	
	@Context
	private ServletContext ctx;
	
	@PostConstruct
	public void init() {
		this.adminDao = (AdminDao) ctx.getAttribute(App.ADMIN_DAO);

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Admin> getAll() {
		return adminDao.getAll().stream().filter(b->b.isNotDeleted()).collect(Collectors.toList());
	}

	/*
	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public String EditAdmin(Admin a) {
		List<Training> trainingList = new ArrayList<Training>();
		trainingList = trainingDao.getByFacilityId(tr.getFacilityId());

		if (!trainingList.stream().anyMatch(t -> t.getName().equals(tr.getName()) && t.getId() != tr.getId())) {
			trainingDao.EditTraining(tr);
			return "uspesno";

		}

		return "ima";

	}
	*/
}
