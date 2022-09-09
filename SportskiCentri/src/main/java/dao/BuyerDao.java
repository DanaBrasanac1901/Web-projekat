package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Type;

import beans.Buyer;
import dto.TrainingDto;
import dto.UserLoginDto;
import main.App;

public class BuyerDao {

	private String filepath = App.path + "/repository/Buyers.json";
	private Map<Integer, Buyer> buyers = new HashMap<>();
	private Buyer logBuyer;

	public BuyerDao() {
	}

	public void loadFile() {

		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Reader reader = Files.newBufferedReader(Paths.get(filepath));
			Type typeOfHashMap = new TypeToken<Map<Integer, Buyer>>() {
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
		return (Buyer) buyers.values().stream().filter(b -> b.getUsername().equals(username));

	}

	public Collection<Buyer> getAll() {
		loadFile();
		return buyers.values();
	}

	public boolean doesUsernameExist(String username) {
		loadFile();
		if (buyers.values().stream().anyMatch(b -> b.getUsername().equals(username))) {
			return true;
		} else {
			return false;
		}
	}

	public String addNew(Buyer newBuyer) {
		loadFile();
		if (doesUsernameExist(newBuyer.getUsername())) {
			return "ima";
		} else {
			buyers.put(makeNewKey(), newBuyer);
			updateFile();
			return "uspesno";
		}

	}

	public int makeNewKey() {
		return (buyers.size() + 1);
	}

	public String loginBuyer(UserLoginDto user) {

		String username = user.getUsername();
		String password = user.getPassword();
		loadFile();

		if (doesUsernameExist(username)) {

			if (getByUsername(username).isBanned()) {
				return "banned";
			} else if (getByUsername(username).isDeleted()) {
				return "deleted";
			} else if (password.equals(getByUsername(username).getPassword())) {
				logBuyer = getByUsername(username);
				return "buyer";
			} else {
				return "wrong password";
			}
		}
		return "not";

	}

}
