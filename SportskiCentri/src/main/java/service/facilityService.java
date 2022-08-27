package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Facility;
import beans.FacilityType;
import dao.FacilityDao;
import dto.FacilityDto;
import main.App;

@Path("/facilities")
public class FacilityService {

	@Context
	private ServletContext ctx;

	private FacilityDao facilityDao;

	@PostConstruct
	public void init() {
		this.facilityDao = (FacilityDao) ctx.getAttribute(App.FACILITY_DAO);
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
	public List<FacilityDto> search(@QueryParam("criteria") String criteria, @QueryParam("content") String content) {

		List<FacilityDto> searchResult = new ArrayList<FacilityDto>();
		List<FacilityDto> allDtos = getAll();

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

			searchResult = allDtos.stream().filter(dto -> dto.getGrade() == Double.parseDouble(content))
					.collect(Collectors.toList());
		}
		return searchResult;
	}

	/*
	@GET
	@Path("/types")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllTypes() {
		return Stream.of(FacilityType.values()).map(FacilityType::toString).collect(Collectors.toList());

	}
	*/

}
