package beans;
import java.time.LocalTime;
import java.util.List;

public class Facility {
	private String name;
	private FacilityType facType;
	private  List<FacilityContent> facContents;
	
	private FacilityStatus facStatus;
	private Location location;
	private String logoPath;
	private double grade;
	private boolean deleted;
	private LocalTime start;
	private LocalTime end;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FacilityType getFacType() {
		return facType;
	}
	public void setFacType(FacilityType facType) {
		this.facType = facType;
	}
	public List<FacilityContent> getFacContents() {
		return facContents;
	}
	public void setFacContents(List<FacilityContent> facContents) {
		this.facContents = facContents;
	}
	public FacilityStatus getFacStatus() {
		return facStatus;
	}
	public void setFacStatus(FacilityStatus facStatus) {
		this.facStatus = facStatus;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public LocalTime getStart() {
		return start;
	}
	public void setStart(LocalTime start) {
		this.start = start;
	}
	public LocalTime getEnd() {
		return end;
	}
	public void setEnd(LocalTime end) {
		this.end = end;
	}
	public Facility(String name, FacilityType facType, List<FacilityContent> facContents, FacilityStatus facStatus,
			Location location, String logoPath, double grade, boolean deleted, LocalTime start, LocalTime end) {
		super();
		this.name = name;
		this.facType = facType;
		this.facContents = facContents;
		this.facStatus = facStatus;
		this.location = location;
		this.logoPath = logoPath;
		this.grade = grade;
		this.deleted = deleted;
		this.start = start;
		this.end = end;
	}
	
	
	
	
	
	
	
	

}
