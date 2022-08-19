package beans;

public class Training {
	
	private String name;
	private String id;
	private TrainingType type;
	private Facility fac;
	private int duration;
	private  Trainer trainer;
	private String description;
	private String picturePath;
	
	private boolean isDeleted;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TrainingType getType() {
		return type;
	}

	public void setType(TrainingType type) {
		this.type = type;
	}

	public Facility getFac() {
		return fac;
	}

	public void setFac(Facility fac) {
		this.fac = fac;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Training(String name, String id, TrainingType type, Facility fac, int duration, Trainer trainer,
			String description, String picturePath, boolean isDeleted) {
		super();
		this.name = name;
		this.id = id;
		this.type = type;
		this.fac = fac;
		this.duration = duration;
		this.trainer = trainer;
		this.description = description;
		this.picturePath = picturePath;
		this.isDeleted = isDeleted;
	}

	public Training(String name, String id, TrainingType type, Facility fac, int duration, String description,
			String picturePath, boolean isDeleted) {
		super();
		this.name = name;
		this.id = id;
		this.type = type;
		this.fac = fac;
		this.duration = duration;
		this.description = description;
		this.picturePath = picturePath;
		this.isDeleted = isDeleted;
	}
	
	
	
	

}
