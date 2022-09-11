package dto;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import beans.Gender;
import beans.Role;
import beans.User;

public class UserEditDto {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Gender gender;
	private String birthDate;
	private Role userRole;
	
	
	
	
	public UserEditDto() {
		// TODO Auto-generated constructor stub
	}
	public UserEditDto(String username, String password, String firstName, String lastName, Gender gender,
			Date birthDate, Role userRole) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		this.birthDate =  dateFormat.format(birthDate);
		this.userRole = userRole;
	}
	
	public UserEditDto(User u) {
		super();
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.firstName = u.getFirstName();
		this.lastName = u.getLastName();
		this.gender = u.getGender();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		this.birthDate =  dateFormat.format(u.getBirthDate());
		this.userRole = u.getUserRole();
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		this.birthDate =  dateFormat.format(birthDate);
	}
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	
	
	
	
}
