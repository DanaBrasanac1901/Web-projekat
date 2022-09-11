package beans;

import java.time.LocalDate;
import java.util.Date;

import dto.UserDto;

public class Manager extends User{
	private int facilityId;

	public Manager() {
		super();
		
	}

	public Manager(String username, String password, String firstName, String lastName, Gender gender, Date birthDate, int facilityId) {
		super(username, password, firstName, lastName, gender, birthDate, Role.MANAGER);
		this.facilityId = facilityId;
	}

	public Manager(String username, String password, String firstName, String lastName, Gender gender, Date birthDate) {
		super(username, password, firstName, lastName, gender, birthDate, Role.MANAGER);
		this.facilityId = 0;
	}
	
	public Manager(UserDto u) {
		super(u.getUsername(), u.getPassword(), u.getFirstName(), u.getLastName(), u.getGender(), u.getBirthDate(), Role.MANAGER);
		
	}

	public int getFacility() {
		return facilityId;
	}

	public void setFacility(int facility) {
		this.facilityId = facility;
	}
	
	
	
	
	
	

}
