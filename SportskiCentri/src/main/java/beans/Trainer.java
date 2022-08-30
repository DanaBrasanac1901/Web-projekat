package beans;

import java.sql.Date;
import java.util.List;

public class Trainer extends User{
	private List<HistoryTraining> trainingHistory;

	public List<HistoryTraining> getTrainingHistory() {
		return trainingHistory;
	}

	public void setTrainingHistory(List<HistoryTraining> trainingHistory) {
		this.trainingHistory = trainingHistory;
	}

	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(List<HistoryTraining> trainingHistory) {
		super();
		this.trainingHistory = trainingHistory;
	}

	public Trainer(String username, String password, String firstName, String lastName, Gender gender, Date birthDate,
			boolean deleted, List<HistoryTraining> trainingHistory) {
		super(username, password, firstName, lastName, gender, birthDate, deleted, Role.TRAINER);
		this.trainingHistory = trainingHistory;
	}

	
	

}
