package main;
import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import dao.FacilityDao;

@ApplicationPath("/rest")
public class App extends Application {
	
	public static String path;
	
	public static final String FACILITY_DAO = "facilityDao";
	
	@Context
	private ServletContext ctx;
	
	@PostConstruct
	public void init() {
    	path = ctx.getRealPath("");
		
		ctx.setAttribute(FACILITY_DAO, new FacilityDao());
	}
	
}
