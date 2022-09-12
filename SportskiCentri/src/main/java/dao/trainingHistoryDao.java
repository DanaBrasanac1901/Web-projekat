package dao;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import beans.Admin;
import beans.Facility;
import beans.HistoryTraining;
import beans.Trainer;
import dto.FacilityDto;
import main.App;

public class trainingHistoryDao {

	private String filepath = App.path + "/repository/TrainingHistory.json";
	private List<HistoryTraining>  historyTraining= new ArrayList<HistoryTraining>() ;
	private Trainer logTrainer;
	
	
	public trainingHistoryDao() {
		loadFile();
	}
	
	public void loadFile() {

		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Reader reader = Files.newBufferedReader(Paths.get(filepath));
			Type listType = new TypeToken<List<String>>() {}.getType();
			historyTraining = gson.fromJson(reader, listType);
			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}
	
	public void updateFile() {
		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Writer writer = Files.newBufferedWriter(Paths.get(filepath));
			gson.toJson( historyTraining, writer);
			writer.close();

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}
	
	public List<HistoryTraining> getAll(){
		loadFile();
		return historyTraining;
	}
	
	
	public List<HistoryTraining> getByTrainingId(int id) {
		loadFile();
		return  historyTraining.stream().filter(b->b.isNotDeleted() && b.getTrainingId()==id).collect(Collectors.toList());
		
	}
	
	public List<HistoryTraining> getByTrainerUsername(String username) {
		loadFile();
		return  historyTraining.stream().filter(b->b.isNotDeleted() && b.getTrainerUsername().contentEquals(username)).collect(Collectors.toList());
		
	}
}
