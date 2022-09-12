package dto;

import java.util.Date;

import beans.HistoryTraining;
import beans.Training;
import beans.TrainingType;

public class TrainingTrainingHistoryDto extends Training{
	protected String date;
	private String dateAppointment;
	
	
	public TrainingTrainingHistoryDto() {
		// TODO Auto-generated constructor stub
	}


	@SuppressWarnings("deprecation")
	public TrainingTrainingHistoryDto(Training t, HistoryTraining hT) {
		super(t);
		this.date = hT.getDate().toGMTString();
		this.dateAppointment = hT.getDateAppointment().toGMTString();

		// TODO Auto-generated constructor stub
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDateAppointment() {
		return dateAppointment;
	}


	public void setDateAppointment(String dateAppointment) {
		this.dateAppointment = dateAppointment;
	}
	
	
	
}
