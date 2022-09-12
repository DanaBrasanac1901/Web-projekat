package dao;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import beans.Facility;
import beans.Training;
import beans.TrainingType;
import main.App;

public class TrainingDao {

	private Map<Integer, Training> trainings = new HashMap<>();
	private String filepath = App.path + "/repository/Trainings.json";

	public TrainingDao() {
		
	}

	private void loadFile() {

		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			Reader reader = Files.newBufferedReader(Paths.get(filepath));

			Type typeOfHashMap = new TypeToken<Map<Integer, Training>>() {
			}.getType();
			trainings = gson.fromJson(reader, typeOfHashMap);

			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateFile() {
		try {
			/*
			 * traings.put(1, new Training("Joga",
			 * 1,TrainingType.GROUP,1,60,"trainer1","Drevna indijska vestina joge"
			 * ,"images\\BarneySaLoptom.jpg",300)); traings.put(2, new Training("Pilates",
			 * 2,TrainingType.GROUP,1,60,"trainer2","Istezanje na strunjaci"
			 * ,"images\\BarneySaKnjigom.jpg",0)); traings.put(3, new
			 * Training("Licni trening",
			 * 3,TrainingType.PERSONAL,1,60,"trainer1","Trening sa profesionalnim osobljem"
			 * ,"images\\BarnetZija.jpg",200)); traings.put(4, new Training("Plivanje",
			 * 4,TrainingType.PERSONAL,2,60,"trainer3","Individualno plivanje sa trenerom."
			 * ,"images\\BarneySedi.jpg",200)); traings.put(5, new Training("Vaterpolo",
			 * 5,TrainingType.GROUP,2,60,"trainer3","Dobacivanje loptom u vodi."
			 * ,"images\\BarneySedi.jpg",200)); traings.put(6, new Training("Judo",
			 * 5,TrainingType.PERSONAL,3,60,"trainer4","Individualni trening judoa."
			 * ,"images\\BarnetZija.jpg",0)); traings.put(7, new Training("Karate",
			 * 5,TrainingType.GROUP,3,60,"trainer5","Grupni trening karatea"
			 * ,"images\\BarneySaKnjigom.jpg",0));
			 */

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Writer writer = Files.newBufferedWriter(Paths.get(filepath));
			gson.toJson(trainings, writer);
			writer.close();
		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}

	public Collection<Training> getAll() {
		loadFile();
		return trainings.values();
	}

	public Training getById(int id) {
		loadFile();
		return trainings.get(id);
	}
	
	public List<Training> getByFacilityId(int facId) {
		
		return getAll().stream().filter(t -> t.getFacilityId() == facId).collect(Collectors.toList());
	}


	
	
	public void addNewTraining(Training newTraining) {
		loadFile();
		
		if(newTraining.getId() <1) {
		newTraining.setId(makeNewTrainingId());	
		}
		trainings.put(newTraining.getId(), newTraining);
		updateFile();
		
	}
	
	public int makeNewTrainingId() {
		
		return getAll().size()+1;
	}

	public void EditTraining(Training tr){
		loadFile();
		trainings.remove(tr.getId());
		trainings.put(tr.getId(), tr);
		updateFile();
		
		
	}
	
	
	
	
}
