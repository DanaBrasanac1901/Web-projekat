package dao;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import beans.Buyer;
import beans.Membership;
import main.App;

public class MembershipDao {

	private Map<String, Membership> memberships = new HashMap<>();
	private String filepath = App.path + "/repository/Memberships.json";

	

	public MembershipDao() {

	}

	private void loadFile() {

		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			Reader reader = Files.newBufferedReader(Paths.get(filepath));

			Type typeOfHashMap = new TypeToken<Map<String, Membership>>() {
			}.getType();
			memberships = gson.fromJson(reader, typeOfHashMap);
			
			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateFile() {
		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Writer writer = Files.newBufferedWriter(Paths.get(filepath));
			gson.toJson(memberships, writer);
			writer.close();
		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}

	public Collection<Membership> getAll() {
		loadFile();
		return memberships.values();
	}
	
	public Membership getById(String id) {
		loadFile();
		return memberships.get(id);
	}
	
}
