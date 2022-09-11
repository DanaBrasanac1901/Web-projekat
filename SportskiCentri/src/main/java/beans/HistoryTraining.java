package beans;

import java.util.Date;
import java.util.Objects;

public class HistoryTraining {

	private int trainingId;
	private String trainerUsername;
	protected Date date;
	private Date dateAppointment;

	


	public HistoryTraining(int trainingId, String trainerUsername, Date date, Date dateAppointment) {
		super();
		this.trainingId = trainingId;
		this.trainerUsername = trainerUsername;
		this.date = date;
		this.dateAppointment = dateAppointment;
	}

	public Date getDateAppointment() {
		return dateAppointment;
	}

	public void setDateAppointment(Date dateAppointment) {
		this.dateAppointment = dateAppointment;
	}

	public HistoryTraining() {

	}

	public HistoryTraining(int trainingId, String trainerUsername, Date date) {
		this.trainingId = trainingId;
		this.trainerUsername = trainerUsername;
		this.date = date;
	}

	public HistoryTraining(int trainingId, Date date) {
		this.trainingId = trainingId;
		this.date = date;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int id) {
		this.trainingId = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTrainerUsername() {
		return trainerUsername;
	}

	public void setTrainerUsername(String trainerUsername) {
		this.trainerUsername = trainerUsername;
	}

}
