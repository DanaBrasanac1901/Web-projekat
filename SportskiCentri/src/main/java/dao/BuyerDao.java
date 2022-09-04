package dao;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.json.JSONObject;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
import beans.Facility;
import beans.Gender;
import dto.UserDto;
import dto.UserLoginDto;
import main.App;


public class BuyerDao {
	
	private String filepath =  App.path + "\\repository\\Buyers.json";
    private Map<String , Buyer> buyers = new HashMap<String,Buyer>();
	private Buyer logBuyer;
	

	
	public BuyerDao() {
	}
		
	
	private void loadFile() {


		String json;
		try {
			   json = readFileAsString(filepath);
				buyers = new ObjectMapper().readValue(json, HashMap.class);
			     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
	

	

	
	public void updateFile() {
			try {
			
			JSONObject json = new JSONObject(buyers);
			Writer writer = Files.newBufferedWriter(Paths.get(filepath));
			writer.write(json.toString());
			writer.close();

			} catch (Exception ex) {
		
		     ex.printStackTrace();
			}
	}
			
			
			



	public Buyer getByUsername(String username) {
		loadFile();
		return buyers.get(username);
	}		
	
	
	public Collection<Buyer> getAll() {
		loadFile();
		return buyers.values();
	}

	
	public void addNew(Buyer newBuyer) {
		loadFile();
		String key = newBuyer.getUsername();
		buyers.put(key, new Buyer());
		updateFile();

	}
	
	

	public String loginBuyer(UserLoginDto user) {
		    String username = user.getFirstName();
		    String password = user.getPassword();				
			
		    
		    if(buyers.size() <1) {
		    	loadFile();
		    }
			
			
			if(buyers.containsKey(username)) {
				
	/*			if(buyers.get(username).isBanned()) {
					return "banned";
				}else if(buyers.get(username).isDeleted()) {
					return "deleted";
				}else*/ if(password.equals(buyers.get(username).getPassword())) {
					logBuyer = buyers.get(username);
					return "buyer";
				}else {
					return "wrong password";
				}	
				
			}
				
			
			return "not";
			
	
		
		
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


