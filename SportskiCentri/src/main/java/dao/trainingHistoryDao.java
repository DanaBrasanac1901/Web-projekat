package dao;

import java.util.HashMap;
import java.util.Map;

import beans.Trainer;
import main.App;

public class trainingHistoryDao {

	private String filepath = App.path + "/repository/TrainingHistory.json";
	private Map<String, Trainer> trainers = new HashMap<>();
	private Trainer logTrainer;
	
	
}
