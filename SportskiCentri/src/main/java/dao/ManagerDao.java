package dao;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import beans.Admin;
import beans.Buyer;
import beans.Gender;
import beans.Manager;
import dto.UserLoginDto;
import main.App;

public class ManagerDao {

	private String filepath = App.path + "/repository/Managers.json";
	private Map<String, Manager> managers = new HashMap<>();
	private Manager logManager;

	
	public Manager getLogManager() {
		return logManager;
	}
	public void Delete(String username) {
		loadFile();
		managers.get(username).setDeleted(true);
		updateFile();
		
	}

	public void setLogManager(Manager logManager) {
		this.logManager = logManager;
	}

	public ManagerDao() {
	}

	public void loadFile() {

		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Reader reader = Files.newBufferedReader(Paths.get(filepath));
			Type typeOfHashMap = new TypeToken<Map<String, Manager>>() {
			}.getType();
			managers = gson.fromJson(reader, typeOfHashMap);
			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static String readFileAsString(String file) throws Exception {
		return new String(Files.readAllBytes(Paths.get(file)));
	}

	public void updateFile() {
		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Writer writer = Files.newBufferedWriter(Paths.get(filepath));
			gson.toJson(managers, writer);
			writer.close();

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/*
	 * public void updateFile() { ObjectMapper objectMapper = new ObjectMapper();
	 * objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	 * 
	 * try { objectMapper.writeValue(new FileOutputStream(filepath), buyers); }
	 * catch (IOException e) { System.out.println("Greska prilikom pisanja u fajl");
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public Manager getByUsername(String username) {
		loadFile();
		return managers.get(username);
	}

	public Collection<Manager> getAll() {
		loadFile();
		return managers.values();
	}

	public void addNew(Manager newManager) {
		loadFile();
		managers.put(newManager.getUsername(), newManager);
		updateFile();
	}

	public String loginManager(UserLoginDto user) {

		String username = user.getUsername();
		String password = user.getPassword();

		loadFile();

//		 managers.put("manager", new
//		 Manager("manager","manager","Nikola","Tesla",Gender.MALE,LocalDate.of(2000,
//		 9, 11)));
		// updateFile();
		if (managers.containsKey(username)) {

			if (managers.get(username).isBanned()) {
				return "banned";
			} else if (managers.get(username).isDeleted()) {
				return "deleted";
			} else if (password.equals(managers.get(username).getPassword())) {
				logManager = managers.get(username);
				return "manager";
			} else {
				return "wrong password";
			}

		}
		return "not";

	}
	
	public void SetFacility(int id ,String username) {
	 loadFile();
	 managers.get(username).setFacility(id);
	 updateFile();		
	}
	
	
	public String RegisterNew(Manager newManager) {
		loadFile();
		if(managers.containsKey(newManager.getUsername())) {
	
			return "ima";

		}
		managers.put(newManager.getUsername(), newManager);
		updateFile();
		
		return "uspesno";
	}

	public int GetFacility() {
		// TODO Auto-generated method stub
	//	return 1;
		return logManager.getFacility();
	}
	
	public Boolean DoesContainUsername(String username) {
		loadFile();

		if (managers.containsKey(username)) {
			return true;
		}
		
		return false;
	}
	
	public Boolean DoesContainUsernameExecptLogged(String username) {
		loadFile();
		if(logManager.getUsername().contentEquals(username)) { 
			return false;
		}
		
		if (managers.containsKey(username)) {
			return true;
		}
		
		return false;
	
	}
	
	
	public void Edit(Manager m) {
		loadFile();
		
		managers.remove(logManager.getUsername());
		m.setFacility(logManager.getFacility());
		managers.put(m.getUsername(), m);
		logManager = m;
		updateFile();
		
	}
  
}
