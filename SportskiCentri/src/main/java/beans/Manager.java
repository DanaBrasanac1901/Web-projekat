package beans;

import java.sql.Date;

public class Manager extends User{
	private Facility facility;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String username, String password, String firstName, String lastName, Gender gender, Date birthDate,
			boolean deleted, Facility facility) {
		super(username, password, firstName, lastName, gender, birthDate, deleted, Role.MANAGER);
		this.facility = facility;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	
	

}
