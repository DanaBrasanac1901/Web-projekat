package dto;

import java.sql.Date;

import beans.Gender;
import beans.Manager;
import beans.Role;
import beans.User;

public class ManagerEditDto extends UserEditDto{
	private int facilityId;

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public ManagerEditDto(int facilityId) {
		super();
		this.facilityId = facilityId;
	}

	public ManagerEditDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManagerEditDto(String username, String password, String firstName, String lastName, Gender gender,
			Date birthDate, Role userRole,int facilityId) {
		super(username, password, firstName, lastName, gender, birthDate, userRole);
		this.facilityId = facilityId;
	}

	public ManagerEditDto(Manager u) {
		super(u);
		this.facilityId = u.getFacility();
	}
	
	
	

	
	

}
