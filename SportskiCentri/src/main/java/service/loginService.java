package service;

import javax.ws.rs.core.MediaType;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import beans.User;
import dao.BuyerDao;

@Path("/login")
public class loginService {
	
	@Context
	ServletContext ctx;

	public loginService() {
	}
	
	
	@POST
	@Path("/login")

	public void login() {
		
	
		
	}
	
	

	@POST
	@Path("/lazar")
	public void lazar() {
	
}
	
	

}
