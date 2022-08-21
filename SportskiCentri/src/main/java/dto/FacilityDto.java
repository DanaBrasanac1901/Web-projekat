package dto;

import beans.Facility;
import beans.FacilityType;
import beans.Location;

public class FacilityDto {

	private String name;
	private FacilityType facType;
	private Location location;
	private String logoPath;
	private double grade;
	private String start;
	private String end;

	public FacilityDto(Facility facility) {

		this.name = facility.getName();
		this.facType = facility.getFacType();
		this.location = facility.getLocation();
		this.logoPath = facility.getLogoPath();
		this.grade = facility.getGrade();
		this.start = facility.getStart();
		this.end = facility.getEnd();
	}

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
	
	
	
	
	

}