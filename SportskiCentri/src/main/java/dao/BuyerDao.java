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
		
	/*
	private void loadFile() {

		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			Reader reader = Files.newBufferedReader(Paths.get(filepath));

			Type typeOfHashMap = new TypeToken<Map<String, Buyer>>() {
			}.getType();
			buyers = gson.fromJson(reader, typeOfHashMap);
			
			reader.close();

		} catch (Exception ex) {
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			ex.printStackTrace();
			System.out.println(ex);
		}
	}
	
	*/
	
	
	private void loadFile() {

	/*	if (Files.exists(Paths.get(filepath))) {
			  
		ObjectMapper objectMapper = new ObjectMapper();

		File file = new File(filepath);
		try {

			buyers = objectMapper.readValue(file, new TypeReference<HashMap<String, Buyer>>() {
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		}*/
		
		String json;
		try {
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			System.out.println("///////////////////////////////////////////////////////////////");
			json = readFileAsString(filepath);
			   System.out.println(json);
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
	

	
	
	
	/*
	public void updateFile() {
		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Writer writer = Files.newBufferedWriter(Paths.get(filepath));
			gson.toJson(buyers, writer);
			writer.close();
		
		} catch (Exception ex) {
		
			ex.printStackTrace();
			
		}

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
	*/		
			
			
	public void updateFile() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		try {
			objectMapper.writeValue(new FileOutputStream(filepath), buyers);
		} catch (IOException e) {
			System.out.println("Greska prilikom pisanja u fajl");
			e.printStackTrace();
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
		    String username = user.getUsername();
		    String password = user.getPassword();

		  /*  
		    try {
		        @SuppressWarnings("deprecation")
				UserDto userInfo = new UserDto("buyer", "buyer", "Lazar", "Mijatovic", Gender.MALE);
				Buyer newBuyer = new Buyer(userInfo.getUsername(),userInfo.getPassword(),userInfo.getFirstName(),userInfo.getLastName(),userInfo.getGender());
				
				buyers.put(newBuyer.getUsername(), newBuyer);
				
				
				UserDto userInfo2 = new UserDto("buyer2", "buyer2", "Aleksa", "Mijatovic", Gender.MALE);
				Buyer newBuyer2 = new Buyer(userInfo2.getUsername(),userInfo2.getPassword(),userInfo2.getFirstName(),userInfo2.getLastName(),userInfo2.getGender());
				
				buyers.put(newBuyer2.getUsername(), newBuyer2);
				System.out.println(buyers.size());
				System.out.println(filepath);
				
			
			} catch (Exception ex) {

				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				ex.printStackTrace();
				System.out.println(ex);
			}
		    
		    
		    
			updateFile();	
		
			
		//	System.out.println(json.toString());
			
	//		Gson gs = new Gson();
		    
	
//		    String jsonStr = gs.toJson(buyers);
	//		System.out.println(jsonStr);
	//	    
			
		  
			
		       
		    
		    
		    
	/*	    
		    
		    
				
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////");
				System.out.println(buyers.size());
				System.out.println(App.path);
				
				try {

					//Gson gson = new GsonBuilder().setPrettyPrinting().create();
					Writer writer = Files.newBufferedWriter(Paths.get(filepath));
					JSONObject json = new JSONObject(buyers);
					System.out.println(json);
					    
					writer.write(json.toString());
				//	gson.toJson(buyers, writer);
					writer.close();
				} catch (Exception ex) {

					ex.printStackTrace();
				}
		
		
		*/		// TODO Auto-generated catch block
				
			
		    
		    
		   loadFile();
			
			
			
	
			
			if(buyers.containsKey(username)) {
				
				if(buyers.get(username).isBanned()) {
					return "banned";
				}else if(buyers.get(username).isDeleted()) {
					return "deleted";
				}else if(password.equals(buyers.get(username).getPassword())) {
					logBuyer = buyers.get(username);
					return "buyer";
				}else {
					return "wrong password";
				}	
				
			}
				
			
			return "not";
			
	
		
		
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


