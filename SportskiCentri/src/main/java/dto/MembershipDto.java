package dto;

import beans.Membership;
import beans.MembershipType;

public class MembershipDto{
	
	private MembershipType membershipType;
	private int price;
	private int numberOfEntrances;
	
	public MembershipDto(MembershipType membershipType, int price, int numberOfEntrances) {
		super();
		this.membershipType = membershipType;
		this.price = price;
		this.numberOfEntrances = numberOfEntrances;
	}
	
	public MembershipDto(Membership membership) {
		
		this.membershipType = membership.getMemType();
		this.price = membership.getPrice();
		this.numberOfEntrances = membership.getNumberOfEntrances();
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
	
	
}