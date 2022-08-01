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

@Path("")
public class loginService {
	
	@Context
	ServletContext ctx;

	public loginService() {
	}
	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String login(String username , String password) {
		
	
		return "not";
		
	}
	}
	
	
	


