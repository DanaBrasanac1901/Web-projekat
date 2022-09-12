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
import beans.Role;
import beans.Trainer;
import dto.UserDto;
import dto.UserLoginDto;
import main.App;

public class TrainerDao {
	
	private String filepath = App.path + "/repository/Trainers.json";
	private Map<String, Trainer> trainers = new HashMap<>();
	private Trainer logTrainer;
    
	public Trainer getLogTrainer() {
		return logTrainer;
	}

	public void setLogTrainer(Trainer logTrainer) {
		this.logTrainer = logTrainer;
	}

	public TrainerDao() {
		loadFile();
	}

	public void loadFile() {

		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Reader reader = Files.newBufferedReader(Paths.get(filepath));
			Type typeOfHashMap = new TypeToken<Map<String, Trainer>>() {
			}.getType();
			trainers = gson.fromJson(reader, typeOfHashMap);
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
			gson.toJson(trainers, writer);
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

	public Trainer getByUsername(String username) {
		loadFile();
		return trainers.get(username);
	}

	public Collection<Trainer> getAll() {
		loadFile();
		return trainers.values();
	}

	public String addNew(Trainer newTrainer) {
		loadFile();
		trainers.put(newTrainer.getUsername(), newTrainer);
		updateFile();
		
		return "uspesno";
	}
	
	

	public String loginTrainer(UserLoginDto user) {

		String username = user.getUsername();
		String password = user.getPassword();
		
		
		loadFile();
		
	//	trainers.put("trainer", new Trainer("trainer","trainer","Milan","Milankovic",Gender.MALE,LocalDate.of(2002, 1, 8)));
	//	 updateFile();

			if (trainers.containsKey(username)) {

				if (trainers.get(username).isBanned()) {
					return "banned";
				} else if (trainers.get(username).isDeleted()) {
					return "deleted";
				} else if (password.equals(trainers.get(username).getPassword())) {
					logTrainer = trainers.get(username);
					return "trainer";
				} else {
					return "wrong password";
				}
				
			}
		  return "not";
		
	}
	
	public Boolean DoesContainUsername(String username) {
		loadFile();

		if (trainers.containsKey(username)) {
			return true;
		}
		
		return false;
	}
	

	
	
	
	public Boolean DoesContainUsernameExecptLogged(String username) {
		loadFile();
		if(logTrainer.getUsername().contentEquals(username)) { 
			return false;
		}
		
		if (trainers.containsKey(username)) {
			return true;
		}
		
		return false;
	
	}
	
	public void Edit(Trainer a) {
		loadFile();
		trainers.remove(logTrainer.getUsername());
		a.setTrainingHistory(logTrainer.getTrainingHistory());
		trainers.put(a.getUsername(), a);
		logTrainer = a;
		updateFile();
		
	}
	
	public Trainer getById(String username) {
		return trainers.get(username);
		
		
	}
	
	public void Delete(String username) {
		loadFile();
		trainers.get(username).setDeleted(true);
		updateFile();
		
	}
	
}
