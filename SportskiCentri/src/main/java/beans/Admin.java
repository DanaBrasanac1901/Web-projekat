package beans;

import java.sql.Date;

public class Admin extends User{

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, String firstName, String lastName, Gender gender, Date birthDate,
			boolean deleted) {
		super(username, password, firstName, lastName, gender, birthDate, Role.ADMIN);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
