package beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {
	private int points;
	private BuyerType buyerType;
	private List<Integer> visitedFacilitiesIds;
	protected List<HistoryTraining> trainingHistory;
	private InstantiatedMembership membership;

	//konstruktor za citanje iz jsona
	public Buyer(String username, String password, String firstName, String lastname, Gender gender, LocalDate date,
			Role userRole, int points, BuyerType buyerType, List<Integer> visitedFacilitiesIds,
			List<HistoryTraining> trainingHistory, InstantiatedMembership membership) {

		super(username, password, firstName, lastname, gender, date, Role.BUYER);

		this.points = points;
		this.buyerType = buyerType;

		if (trainingHistory == null) {
			this.trainingHistory = new ArrayList<HistoryTraining>();
		}

		if (visitedFacilitiesIds == null) {
			this.visitedFacilitiesIds = new ArrayList<Integer>();
		}

		this.membership = membership;

	}

	//konstruktor za registraciju
	
	public Buyer(String username, String password, String firstName, String lastName, Gender gender,
			LocalDate birthDate) {

		super(username, password, firstName, lastName, gender, birthDate, Role.BUYER);

		this.points = 0;
		this.buyerType = null;
		this.visitedFacilitiesIds = new ArrayList<Integer>();
		this.trainingHistory = new ArrayList<HistoryTraining>();
		this.membership = null;

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

	public List<Integer> getvisitedFacilitiesIds() {
		return visitedFacilitiesIds;
	}

	public void setvisitedFacilitiesIds(List<Integer> visitedFacilitiesIds) {
		this.visitedFacilitiesIds = visitedFacilitiesIds;
	}

	public List<HistoryTraining> getTrainingHistory() {
		return trainingHistory;
	}

	public void setTrainingHistory(List<HistoryTraining> trainingHistory) {
		this.trainingHistory = trainingHistory;
	}

	public InstantiatedMembership getMembership() {
		return membership;
	}

	public void setMembership(InstantiatedMembership membership) {
		this.membership = membership;
	}

}
