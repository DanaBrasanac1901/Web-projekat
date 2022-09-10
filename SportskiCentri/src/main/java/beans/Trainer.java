package beans;

import java.util.Date;
import java.util.List;

public class Trainer extends User {
	private List<HistoryTraining> trainingHistory;

	public Trainer(String username, String password, String firstName, String lastName, Gender gender,
			Date birthDate, List<HistoryTraining> trainingHistory) {
		super(username, password, firstName, lastName, gender, birthDate, Role.TRAINER);
		this.trainingHistory = trainingHistory;
	}

	public Trainer(String username, String password, String firstName, String lastName, Gender gender,
			Date birthDate) {
		super(username, password, firstName, lastName, gender, birthDate, Role.TRAINER);

	}

	public List<HistoryTraining> getTrainingHistory() {
		return trainingHistory;
	}

	public void setTrainingHistory(List<HistoryTraining> trainingHistory) {
		this.trainingHistory = trainingHistory;
	}

	public Trainer() {
		super();

	}

	public Trainer(List<HistoryTraining> trainingHistory) {
		super();
		this.trainingHistory = trainingHistory;
	}

}
