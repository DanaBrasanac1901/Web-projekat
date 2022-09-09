package beans;

public class Training {

	private String name;
	private int id;
	private TrainingType type;
	private int facilityId;
	private int duration;
	private String trainerUsername;
	private String description;
	private String picturePath;
	private int price;
	private boolean isDeleted;
	
	
	public Training() {
		
		
	}

	public Training(String name, int id, TrainingType type, int fac, int duration, String trainer, String description,
			String picturePath,int price) {
		super();

		this.name = name;
		this.id = id;
		this.type = type;
		this.facilityId = fac;
		this.duration = duration;
		this.trainerUsername = trainer;
		this.description = description;
		this.picturePath = picturePath;
		this.isDeleted = false;
		this.price =price;
	}
	
	
	public Training(String name, int id, TrainingType type, int facilityId, int duration, String trainerUsername,
			String description, String picturePath, int price, boolean isDeleted) {
		super();
		this.name = name;
		this.id = id;
		this.type = type;
		this.facilityId = facilityId;
		this.duration = duration;
		this.trainerUsername = trainerUsername;
		this.description = description;
		this.picturePath = picturePath;
		this.price = price;
		this.isDeleted = isDeleted;
	}
	
	
	

	
	
	public Training(String name, int id, TrainingType type, int fac, String trainer, String picturePath,int price) {
		super();

		this.name = name;
		this.id = id;
		this.type = type;
		this.facilityId = fac;
		this.trainerUsername = trainer;
		this.picturePath = picturePath;
		this.price = price;
		this.isDeleted = false;
	}

	public Training(Training t) {
		this.name = t.name;
		this.id = t.id;
		this.type = t.type;
		this.facilityId = t.facilityId;
		this.duration = t.duration;
		this.trainerUsername = t.trainerUsername;
		this.description = t.description;
		this.picturePath = t.picturePath;
		this.isDeleted = t.isDeleted;
		this.price = t.price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TrainingType getType() {
		return type;
	}

	public void setType(TrainingType type) {
		this.type = type;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFac(int fac) {
		this.facilityId = fac;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTrainer() {
		return trainerUsername;
	}

	public void setTrainer(String trainer) {
		this.trainerUsername = trainer;
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

	public String getTrainerUsername() {
		return trainerUsername;
	}

	public void setTrainerUsername(String trainerUsername) {
		this.trainerUsername = trainerUsername;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public boolean isNotDeleted() {
		return !this.isDeleted;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
