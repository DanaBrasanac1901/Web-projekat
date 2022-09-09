package beans;

import java.time.LocalDate;

public class InstantiatedMembership {

	private String id;
	private boolean deleted;
	private LocalDate payDate;
	private LocalDate expirationDate;
	private Buyer buyer;
	private boolean status;
	private int numberOfEntrances;

	public InstantiatedMembership(String id, boolean deleted, LocalDate payDate, LocalDate expirationDate, int price,
			Buyer buyer, boolean status, int numberOfEntrances) {
		super();
		this.id = id;
		this.deleted = deleted;
		this.payDate = payDate;
		this.expirationDate = expirationDate;
		this.buyer = buyer;
		this.status = status;
		this.numberOfEntrances = numberOfEntrances;
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

	public int getNumberOfEntrances() {
		return numberOfEntrances;
	}

	public void setNumberOfEntrances(int numberOfEntrances) {
		this.numberOfEntrances = numberOfEntrances;
	}

	public boolean isNotDeleted() {
		return !this.deleted;
	}

}