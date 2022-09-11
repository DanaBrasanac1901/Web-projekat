package dto;

import beans.Membership;
import beans.MembershipType;

public class MembershipDto{
	
	private String id;
	private MembershipType membershipType;
	private int price;
	private int numberOfEntrances;
	private boolean status; 
	
	public MembershipDto(String id, MembershipType membershipType, int price, int numberOfEntrances, boolean status) {
		this.id = id;
		this.membershipType = membershipType;
		this.price = price;
		this.numberOfEntrances = numberOfEntrances;
		this.status = status;
		
	}
	
	public MembershipDto(Membership membership) {
		this.id = membership.getId();
		this.membershipType = membership.getMemType();
		this.price = membership.getPrice();
		this.numberOfEntrances = membership.getNumberOfEntrances();
		this.status = false;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public MembershipType getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(MembershipType membershipType) {
		this.membershipType = membershipType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumberOfEntrances() {
		return numberOfEntrances;
	}
	public void setNumberOfEntrances(int numberOfEntrances) {
		this.numberOfEntrances = numberOfEntrances;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}