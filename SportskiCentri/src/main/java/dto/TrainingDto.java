package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrainingDto {

	String trainingName;
	String facilityName;
	List<Date> datesOfTraining;

	public TrainingDto(String trainingName, String facilityName, List<Date> datesOfTraining) {

		this.trainingName = trainingName;
		this.facilityName = facilityName;
		if (datesOfTraining == null) {
			this.datesOfTraining = new ArrayList<Date>();
		} else {
			this.datesOfTraining = datesOfTraining;
		}

	}

	public TrainingDto() {

	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public List<Date> getDatesOfTraining() {
		return datesOfTraining;
	}

	public void setDatesOfTraining(List<Date> datesOfTraining) {
		this.datesOfTraining = datesOfTraining;
	}

	public void addNewDateOfTraining(Date dateOfTraining) {
		List<Date> newList = getDatesOfTraining();
		newList.add(dateOfTraining);
		setDatesOfTraining(newList);
	}

}