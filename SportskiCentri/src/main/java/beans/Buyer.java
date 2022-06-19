package beans;

import java.sql.Date;

public class Buyer extends User {
	private int points;
	private BuyerType buyerType;
	
	
	
	
	
	
	

	public Buyer(String username, String password, String firstName, String lastName, Gender gender, Date birthDate,
			boolean deleted, Role userRole, int points, BuyerType buyerType) {
		super(username, password, firstName, lastName, gender, birthDate, deleted, userRole);
		this.points = points;
		this.buyerType = buyerType;
	}


	

	



	public int getPoints() {
		return points;
	}








	public void setPoints(int points) {
		this.points = points;
	}








	public BuyerType getBuyerType() {
		return buyerType;
	}








	public void setBuyerType(BuyerType buyerType) {
		this.buyerType = buyerType;
	}















	public Buyer(String username, String password, String firstName, String lastName, Gender gender, Date birthDate,
			boolean deleted, Role userRole) {
		super(username, password, firstName, lastName, gender, birthDate, deleted, userRole);
		// TODO Auto-generated constructor stub
	}

}
