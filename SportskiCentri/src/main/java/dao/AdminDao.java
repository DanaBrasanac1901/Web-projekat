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
import beans.Gender;
import dto.UserLoginDto;
import main.App;

public class AdminDao {
	private String filepath = App.path + "/repository/admins.json";
	private Map<String, Admin> admins = new HashMap<>();
	private Admin logAdmin;

	public AdminDao() {
	}

	public void loadFile() {

		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Reader reader = Files.newBufferedReader(Paths.get(filepath));
			Type typeOfHashMap = new TypeToken<Map<String, Admin>>() {
			}.getType();
			admins = gson.fromJson(reader, typeOfHashMap);
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
			gson.toJson(admins, writer);
			writer.close();

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/*
	 * public void updateFile() { ObjectMapper objectMapper = new ObjectMapper();
	 * objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	 * 
	 * try { objectMapper.writeValue(new FileOutputStream(filepath), admins); }
	 * catch (IOException e) { System.out.println("Greska prilikom pisanja u fajl");
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public Admin getByUsername(String username) {
		loadFile();
		return admins.get(username);
	}

	public Collection<Admin> getAll() {
		loadFile();
		return admins.values();
	}

	public void addNew(Admin newAdmin) {
		loadFile();
		admins.put(newAdmin.getUsername(), newAdmin);
		updateFile();
	}
	
	

	public String loginAdmin(UserLoginDto user) {

		String username = user.getUsername();
		String password = user.getPassword();
		loadFile();
		//admins.put("admin", new Admin("admin","admin","Milan","Obrenovic",Gender.MALE,LocalDate.of(1999, 10, 10)));
    	 //updateFile();

		
		
			if (admins.containsKey(username)) {

				if (admins.get(username).isBanned()) {
					return "banned";
				} else if (admins.get(username).isDeleted()) {
					return "deleted";
				} else if (password.equals(admins.get(username).getPassword())) {
					logAdmin = admins.get(username);
					return "admin";
				} else {
					return "wrong password";
				}
				
			}
		  return "not";
		
	}


}

