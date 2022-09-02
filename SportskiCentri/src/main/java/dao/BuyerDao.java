package dao;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;


import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

import java.lang.reflect.Type;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import beans.Buyer;


public class BuyerDao {

	private String filePath ="";
	public HashMap<String , Buyer> buyers = new HashMap<String,Buyer>();
	private Buyer logBuyer;
	
	
	
	

	public HashMap<String, Buyer> getBuyers() {
		loadBuyers();
		return buyers;
	}





	public void setBuyers(HashMap<String, Buyer> buyers) {
		this.buyers = buyers;
	}





	private void  loadBuyers() {
		Gson g = new Gson();
		
		String buyersJson = "";
		
		try {
			buyersJson = new String(Files.readAllBytes(null));
		
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Greska prilikom citanja fajla");
		}
		
		Type t = new TypeToken<HashMap<String, Buyer>>() {}.getType();
		
		buyers.clear();
		
		buyers = g.fromJson(buyersJson,t);
	}

	
	

		
	


	public String loginBuyer(String username, String password) {
			if(buyers.containsKey(username)) {
				if(buyers.get(username).isBanned()) {
					return "banned";
				}
				if(buyers.get(username).isDeleted()) {
					return "deleted";
				}
				if(buyers.get(username).getPassword()==password) {
					
					logBuyer = buyers.get(username);
					return "buyer";
				}else {
					return "wrong password";
				}
				
			}
			return "not";
			
	
		
		
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


