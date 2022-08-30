package beans;

import java.sql.Date;
import java.util.List;

public class Buyer extends User {
	private int points;
	private BuyerType buyerType;
	private List<Facility> visitedFacilities;
	private  List<HistoryTraining> trainingHistory;
	private Membership membership;
	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Buyer(String username, String password, String firstName, String lastName, Gender gender, Date birthDate,
			boolean deleted, int points, BuyerType buyerType, List<Facility> visitedFacilities,
			List<HistoryTraining> trainingHistory, Membership membership) {
			super(username, password, firstName, lastName, gender, birthDate, deleted, Role.BUYER);
		this.points = points;
		this.buyerType = buyerType;
		this.visitedFacilities = visitedFacilities;
		this.trainingHistory = trainingHistory;
		this.membership = membership;
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
	public List<Facility> getVisitedFacilities() {
		return visitedFacilities;
	}
	public void setVisitedFacilities(List<Facility> visitedFacilities) {
		this.visitedFacilities = visitedFacilities;
	}
	public List<HistoryTraining> getTrainingHistory() {
		return trainingHistory;
	}
	public void setTrainingHistory(List<HistoryTraining> trainingHistory) {
		this.trainingHistory = trainingHistory;
	}
	public Membership getMembership() {
		return membership;
	}
	public void setMembership(Membership membership) {
		this.membership = membership;
	}
	
	
	
 	
	
	
	
	
	


}
