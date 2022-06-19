package beans;

import java.sql.Date;

public class Buyer extends User {
	
	
	
	
	
	

	public Buyer(String username, String password, String firstName, String lastName, Gender gender, Date birthDate,
			boolean deleted, Role userRole) {
		super(username, password, firstName, lastName, gender, birthDate, deleted, userRole);
		// TODO Auto-generated constructor stub
	}

}
