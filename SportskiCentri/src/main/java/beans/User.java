package beans;

import java.time.LocalDate;


public class User {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Gender gender;
	protected LocalDate birthDate;
	private boolean deleted;
	private boolean isBanned;
	private Role userRole;
	
	
	
	public User(String username, String password, String firstName, String lastName, Gender gender, LocalDate dateOfBirth, Role userRole) {
		
		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = dateOfBirth;
		this.deleted = false;
		this.isBanned = false;
		this.userRole = userRole;
		
	}
	
	public User() {
		
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
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	
	public boolean isBanned() {
		return isBanned;
	}
	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}
	
	public boolean isNotDeleted() {
		return !this.deleted;
	}


}
