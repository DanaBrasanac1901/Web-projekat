package main;
import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import dao.BuyerDao;
import dao.FacilityDao;
import dao.TrainingDao;


@ApplicationPath("/rest")
public class App extends Application {
	
	public static String path;
	
	public static final String FACILITY_DAO = "facilityDao";
	public static final String BUYER_DAO = "buyerDao";
	public static final String TRAINING_DAO = "trainingDao";
	
	
	@Context
	private ServletContext ctx;
	
	@PostConstruct
	public void init() {
    	path = ctx.getRealPath("");
		//path = "C:\\Users\\DLAKAVI TALAMBAS\\Documents\\GitHub\\Web-projekat\\SportskiCentri\\src\\main\\webapp";
		ctx.setAttribute(FACILITY_DAO, new FacilityDao());
		ctx.setAttribute(BUYER_DAO, new BuyerDao());
		ctx.setAttribute(TRAINING_DAO, new TrainingDao());
		
	}
	
	
}
