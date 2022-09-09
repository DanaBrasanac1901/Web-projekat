package beans;

public class Membership {

	private String id;
	private MembershipType memType;
	private boolean deleted;
	private int price;
	private int numberOfEntrances;

	public Membership(String id, MembershipType memType, boolean deleted, int price, int numberOfEntrances) {

		this.id = id;
		this.memType = memType;
		this.deleted = deleted;
		this.price = price;
		this.numberOfEntrances = numberOfEntrances;
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

	public boolean isNotDeleted() {
		return !this.deleted;
	}

}
