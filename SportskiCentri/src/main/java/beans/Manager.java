package beans;

import java.time.LocalDate;
import java.util.Date;

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


	public int getFacility() {
		return facilityId;
	}

	public void setFacility(int facility) {
		this.facilityId = facility;
	}
	
	
	
	
	

}
