package beans;

import java.util.Date;



public class Membership {
	
	private String id;
	private MembershipType memType;
	private boolean deleted;
	private Date payDate;
	private Date expirationDate;
	private int price;
	private Buyer buyer;
	private boolean status;
	private int numberOfEntrennces;
	public Membership(String id, MembershipType memType, boolean deleted, Date payDate, Date expirationDate, int price,
			Buyer buyer, boolean status, int numberOfEntrennces) {
		super();
		this.id = id;
		this.memType = memType;
		this.deleted = deleted;
		this.payDate = payDate;
		this.expirationDate = expirationDate;
		this.price = price;
		this.buyer = buyer;
		this.status = status;
		this.numberOfEntrennces = numberOfEntrennces;
	}
	public Membership() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MembershipType getMemType() {
		return memType;
	}
	public void setMemType(MembershipType memType) {
		this.memType = memType;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getNumberOfEntrennces() {
		return numberOfEntrennces;
	}
	public void setNumberOfEntrennces(int numberOfEntrennces) {
		this.numberOfEntrennces = numberOfEntrennces;
	}
	
	
	
	

}
