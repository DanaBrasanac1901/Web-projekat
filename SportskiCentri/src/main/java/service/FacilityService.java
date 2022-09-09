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

import beans.Adress;
import beans.Facility;
import beans.Location;
import beans.Training;
import dao.FacilityDao;
import dao.TrainingDao;
import dto.CreateNewFacilityDto;
import dto.FacilityDto;

import dto.SearchDto;
import main.App;

@Path("/facilities")
public class FacilityService {

	@Context
	private ServletContext ctx;

	private FacilityDao facilityDao;
	private TrainingDao trainingDao;

	@PostConstruct
	public void init() {
		this.facilityDao = (FacilityDao) ctx.getAttribute(App.FACILITY_DAO);
		this.trainingDao = (TrainingDao) ctx.getAttribute(App.TRAINING_DAO);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FacilityDto> getAll() {
		return facilityDao.getAll().stream().filter(Facility::isNotDeleted).map(f -> new FacilityDto(f))
				.collect(Collectors.toList());

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public FacilityDto getById(@PathParam("id") int id) {
		Facility facility = facilityDao.getById(id);
		return new FacilityDto(facility);
	}

	@POST
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FacilityDto> search(SearchDto search) {

		String criteria = search.getType();
		String content = search.getSearch();
		List<FacilityDto> searchResult = new ArrayList<FacilityDto>();
		List<FacilityDto> allDtos = getAll();
		
		if(content == null || content.isEmpty() || content.trim().isEmpty()) {
			
			return getAll();
		}
		
		
		if (criteria.equals("name")) {

			searchResult = allDtos.stream().filter(dto -> dto.getName().toLowerCase().contains(content.toLowerCase()))
					.collect(Collectors.toList());

		} else if (criteria.equals("type")) {

			searchResult = allDtos.stream()
					.filter(dto -> dto.getFacType().toString().toLowerCase().contains(content.toLowerCase()))
					.collect(Collectors.toList());

		} else if (criteria.equals("location")) {

			searchResult = allDtos.stream().filter(
					dto -> dto.getLocation().getAdress().getCity().toLowerCase().contains(content.toLowerCase()))
					.collect(Collectors.toList());

		} else if (criteria.equals("grade")) {

			searchResult = allDtos.stream().filter(dto -> dto.getGrade() >= Double.parseDouble(content))
					.collect(Collectors.toList());
		} else {
			searchResult = getAll();
		}
		return searchResult;
	}

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createNew(FacilityDto facilityInfo) {

		Facility newFacility = new Facility(facilityInfo.getName(), facilityInfo.getFacType(), null,
				facilityInfo.getStatus(), facilityInfo.getLocation(), facilityInfo.getLogoPath(), 0.0, false, null,
				null, 0);
		facilityDao.addNew(newFacility);

	}
	
	@POST
	@Path("/createNew")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createNewFacility(CreateNewFacilityDto facilityInfo) {

		Facility newFacility = new Facility(facilityInfo.getName(), facilityInfo.getFacilityType(),  new Location(new Adress(facilityInfo.getStreet(),facilityInfo.getStreetNumber(), facilityInfo.getCity(),facilityInfo.getPostalCode()))
		, facilityInfo.getLogoPath());
		facilityDao.addNew(newFacility);

	}


	/*
	 * @GET
	 * 
	 * @Path("/types")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public List<String> getAllTypes() {
	 * return Stream.of(FacilityType.values()).map(FacilityType::toString).collect(
	 * Collectors.toList());
	 * 
	 * }
	 */

	@POST
	@Path("/{id}/new-content")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addNewContent(@PathParam("id") int id, Training newTraining) {

		List<Training> trainingList = new ArrayList<Training>();
		Facility facility = facilityDao.getById(id);
		trainingList = trainingDao.getByFacilityId(id);
		if (!trainingList.stream().anyMatch(t -> t.getName().equals(newTraining.getName()))) {
			int trainingId = makeNewTrainingId();
			newTraining.setId(trainingId);
			List<Integer> newFacilityList = facility.getFacContents();
			newFacilityList.add(trainingId);
			facility.setFacContents(newFacilityList);
			facilityDao.EditFacility(facility);
			trainingDao.addNewTraining(newTraining);
			return "uspesno";
			
		}	
		return "ima";
	}
	
	public int makeNewTrainingId() {
		
		return (trainingDao.getAll().size()+1);
	}
}
