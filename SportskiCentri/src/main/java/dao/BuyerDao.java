package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Type;

import beans.Buyer;
import beans.Gender;
import dto.UserDto;
import dto.UserLoginDto;
import main.App;

public class BuyerDao {

	private String filepath = App.path + "/repository/Buyers.json";
	private Map<String, Buyer> buyers = new HashMap<>();
	private Buyer logBuyer;

	public BuyerDao() {
	}

	public void loadFile() {

		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Reader reader = Files.newBufferedReader(Paths.get(filepath));
			Type typeOfHashMap = new TypeToken<Map<String, Buyer>>() {
			}.getType();
			buyers = gson.fromJson(reader, typeOfHashMap);
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
			gson.toJson(buyers, writer);
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
		buyers.put(newBuyer.getUsername(), newBuyer);
		updateFile();
	}
	
	

	public String loginBuyer(UserLoginDto user) {

		String username = user.getUsername();
		String password = user.getPassword();
		loadFile();

			if (buyers.containsKey(username)) {

				if (buyers.get(username).isBanned()) {
					return "banned";
				} else if (buyers.get(username).isDeleted()) {
					return "deleted";
				} else if (password.equals(buyers.get(username).getPassword())) {
					logBuyer = buyers.get(username);
					return "buyer";
				} else {
					return "wrong password";
				}
				
			}
		  return "not";
		
	}


}

