package dao;


import java.util.HashMap;
import java.util.Map;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import beans.Facility;


public class FacilityDao {
	
	private Map<Integer, Facility> facilities = new HashMap<>();
	private String filepath = "repository/Facility.json";
	
	public FacilityDao() {
	loadFile();
	}
	
	private void loadFile () {
		
		try {
		    
		    Gson gson = new GsonBuilder().setPrettyPrinting().create();

		    Reader reader = Files.newBufferedReader(Paths.get(filepath));
		    Type typeOfHashMap = new TypeToken<Map<Integer, Facility>>() { }.getType();
		    facilities = gson.fromJson(reader, typeOfHashMap);
		   
		    reader.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	

}