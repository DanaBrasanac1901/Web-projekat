package dao;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import beans.Facility;
import main.App;

public class FacilityDao {

	private Map<Integer, Facility> facilities = new HashMap<>();
	private String filepath = App.path + "/repository/Facility.json";

	public FacilityDao() {

	}

	private void loadFile() {

		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Reader reader = Files.newBufferedReader(Paths.get(filepath));
			Type typeOfHashMap = new TypeToken<Map<Integer, Facility>>() {
			}.getType();
			facilities = gson.fromJson(reader, typeOfHashMap);
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateFile(Map<Integer, Facility> newData) {
		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Writer writer = Files.newBufferedWriter(Paths.get(filepath));
			gson.toJson(newData, writer);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	public Collection<Facility> getAll() {
		loadFile();
		return facilities.values();
	}

	public Facility getById(int id) {
		loadFile();
		return facilities.get(id);
	}

	public void addNew(Facility newFacility) {

		int key = makeNewKey();
		facilities.put(key, newFacility);
		updateFile(facilities);

	}

	private int makeNewKey() {
		return (facilities.size() + 1);
	}

}