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

import beans.Buyer;
import beans.Gender;
import beans.Trainer;
import dto.UserLoginDto;
import main.App;

public class TrainerDao {
	
	private String filepath = App.path + "/repository/Trainers.json";
	private Map<String, Trainer> trainers = new HashMap<>();
	private Trainer logTrainer;

	public TrainerDao() {
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

	public void addNew(Trainer newTrainer) {
		loadFile();
		trainers.put(newTrainer.getUsername(), newTrainer);
		updateFile();
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
	
	public String DoesContainUsername(String username) {
		loadFile();

		if (trainers.containsKey(username)) {
			return "ima";
		}
		
		return "nema";
	}

}
