package beans;

import java.time.LocalDate;
import java.util.Date;

import dto.UserDto;

public class Admin extends User{

	public Admin() {
		super();
		
	}

	public Admin(String username, String password, String firstName, String lastName, Gender gender, Date birthDate) {
		super(username, password, firstName, lastName, gender, birthDate, Role.ADMIN);
		
	}
	
	
	public Admin(UserDto u) {
		super(u.getUsername(), u.getPassword(), u.getFirstName(), u.getLastName(), u.getGender(), u.getBirthDate(), Role.ADMIN);
		
	}
	
	
	

}
