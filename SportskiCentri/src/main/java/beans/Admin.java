package beans;

import java.time.LocalDate;
import java.util.Date;

public class Admin extends User{

	public Admin() {
		super();
		
	}

	public Admin(String username, String password, String firstName, String lastName, Gender gender, Date birthDate) {
		super(username, password, firstName, lastName, gender, birthDate, Role.ADMIN);
		
	}
	
	
	
	

}
