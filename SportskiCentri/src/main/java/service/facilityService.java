package service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Facility;
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
		return facilityDao.getAll()
				.stream()
				.filter(Facility::isNotDeleted)
				.map(f -> new FacilityDto(f))
				.collect(Collectors.toList());

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public FacilityDto getById(@PathParam("id") int id) {
		Facility facility = facilityDao.getById(id);
		return new FacilityDto(facility);
	}
}
