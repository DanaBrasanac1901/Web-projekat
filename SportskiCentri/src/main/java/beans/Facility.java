package beans;

import java.util.List;

public class Facility {
	
	private String name;
	private FacilityType facType;
	private  List<Training> facContents;
	private FacilityStatus facStatus;
	private Location location;
	private String logoPath;
	private double grade;
	private boolean deleted;
	private String start;
	private String end;
	private int id;
	
	
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
	public List<Training> getFacContents() {
		return facContents;
	}
	public void setFacContents(List<Training> facContents) {
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
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Facility() {

	}
	public Facility(String name, FacilityType facType, List<Training> facContents, FacilityStatus facStatus,
			Location location, String logoPath, double grade, boolean deleted, String start, String end,
			int id) {
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
		this.id = id;
	}
	
	
	
	public Facility(String name, FacilityType facType, 
			Location location, String logoPath) {
		this.name = name;
		this.facType = facType;
		this.facStatus = facStatus;
		this.location = location;
		this.logoPath = logoPath;
		this.deleted = false;
		this.start =  "07:00";
		this.end = "20:00";
		this.facStatus = FacilityStatus.OPEN;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public boolean isNotDeleted() {
		return !this.deleted;
	}
	
	
	
	
	
	

}
