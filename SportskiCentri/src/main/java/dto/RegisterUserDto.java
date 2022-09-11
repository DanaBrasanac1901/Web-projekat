package dto;



import java.util.Date;

import beans.Gender;

public class RegisterUserDto {
	
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Date birthDate;
	
	
	
	public RegisterUserDto() {
		// TODO Auto-generated constructor stub
	}



	public RegisterUserDto(String username, String password, String firstName, String lastName, Gender gender,
			Date birthDate) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
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




	
	

}
