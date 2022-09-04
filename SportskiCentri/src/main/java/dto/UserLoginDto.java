package dto;

public class UserLoginDto {
	
	    private String firstName;
		private String password;
		
		public UserLoginDto() {
		
		}

		

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public UserLoginDto(String firstName, String password) {
			super();
			this.firstName = firstName;
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}
		
		
	

}
