package beans;

import java.time.LocalDate;

public class InstantiatedMembership {

	private String id;
	private boolean deleted;
	private LocalDate payDate;
	private LocalDate expirationDate;
	private String buyer;
	private boolean status;
	private int numberOfEntrances;
	private int remainingEntrances;
	private int price;

	public InstantiatedMembership(String id, boolean deleted, LocalDate payDate, LocalDate expirationDate, int price,
			String buyer, boolean status, int numberOfEntrances, int remainingEntrances) {
		
		this.id = id;
		this.deleted = deleted;
		this.payDate = payDate;
		this.price = price;
		this.expirationDate = expirationDate;
		this.buyer = buyer;
		this.status = status;
		this.numberOfEntrances = numberOfEntrances;
		this.remainingEntrances = remainingEntrances;
	}

	public InstantiatedMembership() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public LocalDate getPayDate() {
		return payDate;
	}

	public void setPayDate(LocalDate payDate) {
		this.payDate = payDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getNumberOfEntrances() {
		return numberOfEntrances;
	}

	public void setNumberOfEntrances(int numberOfEntrances) {
		this.numberOfEntrances = numberOfEntrances;
	}

	public boolean isNotDeleted() {
		return !this.deleted;
	}

	public int getRemainingEntrances() {
		return remainingEntrances;
	}

	public void setRemainingEntrances(int remainingEntrances) {
		this.remainingEntrances = remainingEntrances;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}