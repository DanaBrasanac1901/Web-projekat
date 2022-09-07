package dto;

import beans.FacilityType;

public class CreateNewFacilityDto {
	String name;
    FacilityType facilityType;
    String street;
    String streetNumber;
    String city;
    String postalCode;
    String logoPath;
    String username;
    
    
    public CreateNewFacilityDto() {
		// TODO Auto-generated constructor stub
	}



	public CreateNewFacilityDto(String name, FacilityType facilityType, String street, String streetNumber, String city,
			String postalCode, String logoPath, String username) {
		super();
		this.name = name;
		this.facilityType = facilityType;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.postalCode = postalCode;
		this.logoPath = logoPath;
		this.username = username;
	}


	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public FacilityType getFacilityType() {
		return facilityType;
	}



	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getStreetNumber() {
		return streetNumber;
	}



	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public String getLogoPath() {
		return logoPath;
	}



	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
    
    

}
