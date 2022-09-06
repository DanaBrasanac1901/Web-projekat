package beans;

import java.util.Date;

public class HistoryTraining {

	private int trainingId;
	private int buyerId;
	private int trainerId;
	protected Date date;

	public HistoryTraining() {
		super();

	}

	public HistoryTraining(int trainingId, int buyerId, int trainerId, Date date) {
		super();
		this.trainingId = trainingId;
		this.buyerId = buyerId;
		this.trainerId = trainerId;
		this.date = date;
	}

	public HistoryTraining(int trainingId, int buyer, Date date) {
		super();
		this.trainingId = trainingId;
		this.buyerId = buyer;
		this.date = date;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int id) {
		this.trainingId = id;
	}

	public int getBuyer() {
		return buyerId;
	}

	public void setBuyer(int id) {
		this.buyerId = id;
	}

	public int getTrainer() {
		return trainerId;
	}

	public void setTrainer(int id) {
		this.trainerId = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
