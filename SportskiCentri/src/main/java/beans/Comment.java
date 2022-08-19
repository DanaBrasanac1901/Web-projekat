package beans;

public class Comment {
	private String id;
	private Buyer author;
	private Facility facility;
	private String text;
	private int raiting;
	private CommentState state  = CommentState.WAITING;
	private boolean deleted;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Buyer getAuthor() {
		return author;
	}
	public void setAurhor(Buyer aurhor) {
		this.author = aurhor;
	}
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getRaiting() {
		return raiting;
	}
	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}
	public CommentState getState() {
		return state;
	}
	public void setState(CommentState state) {
		this.state = state;
	}
	public Comment( Buyer aurhor, Facility facility, String text, int raiting, CommentState state) {
		super();
		this.id = aurhor.getUsername() + facility.getId();
		this.author = aurhor;
		this.facility = facility;
		this.text = text;
		this.raiting = raiting;
		this.state = state;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public void setAuthor(Buyer author) {
		this.author = author;
	}
	
	
	
}
