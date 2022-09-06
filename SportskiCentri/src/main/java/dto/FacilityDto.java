package dto;

import beans.Facility;
import beans.FacilityStatus;
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
	private FacilityStatus status;
	private int id;

	public FacilityDto(Facility facility) {

		this.name = facility.getName();
		this.facType = facility.getFacType();
		this.location = facility.getLocation();
		this.logoPath = facility.getLogoPath();
		this.grade = facility.getGrade();
		this.start = facility.getStart();
		this.end = facility.getEnd();
		this.status = facility.getFacStatus();
		this.id = facility.getId();
	}

	public FacilityDto() {

	}

	public FacilityDto(String name, FacilityType facType, Location location, String logoPath, double grade,
			String start, String end, FacilityStatus status, int id) {

		this.name = name;
		this.facType = facType;
		this.location = location;
		this.logoPath = logoPath;
		this.grade = grade;
		this.start = start;
		this.end = end;
		this.status = status;
		this.id = id;
	}



	public FacilityDto(String name, FacilityType facType, Location location, String logoPath, double grade,
			String start, String end, FacilityStatus status) {

		this.name = name;
		this.facType = facType;
		this.location = location;
		this.logoPath = logoPath;
		this.grade = grade;
		this.start = start;
		this.end = end;
		this.status = status;
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

	public FacilityStatus getStatus() {

		return status;
	}

	public void setStatus(FacilityStatus status) {

		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
