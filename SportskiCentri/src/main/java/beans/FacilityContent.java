package beans;

public class FacilityContent {
	String id;
	String name;
	String deleted;
	public FacilityContent(String id, String name, String deleted) {
		super();
		this.id = id;
		this.name = name;
		this.deleted = deleted;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	
	
	
}
