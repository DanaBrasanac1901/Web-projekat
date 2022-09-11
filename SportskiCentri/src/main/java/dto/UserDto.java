package dto;



import java.util.Date;

import beans.Gender;
import beans.Role;

public class UserDto {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Date birthDate;
	private Role userRole;

	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	// registracija
	public UserDto(String username, String password, String firstName, String lastName, Gender gender, Date birthDate) {

		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate =  birthDate;
		System.out.println();
	}

	public UserDto(String username, String password, String firstname, String lastname, Gender gender) {
		this.username = username;
		this.password = password;
		this.firstName = firstname;
		this.lastName = lastname;
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	

}
