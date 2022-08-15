package beans;

import java.time.LocalTime;
import java.util.Date;

public class HistoryTraining {
	
	private String id;
	private Training training;
	private Buyer buyer;
	private Trainer trainer;
	private Date date;
	private LocalTime time;
	public HistoryTraining() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoryTraining(String id, Training training, Buyer buyer, Trainer trainer, Date date, LocalTime time) {
		super();
		this.id = id;
		this.training = training;
		this.buyer = buyer;
		this.trainer = trainer;
		this.date = date;
		this.time = time;
	}
	public HistoryTraining(String id, Training training, Buyer buyer, Date date, LocalTime time) {
		super();
		this.id = id;
		this.training = training;
		this.buyer = buyer;
		this.date = date;
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}

	

}
