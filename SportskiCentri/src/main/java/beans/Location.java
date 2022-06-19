package beans;

public class Location {
	
	private Adress adress;
	private double width;
	private double length;
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Location(Adress adress, double width, double length) {
		super();
		this.adress = adress;
		this.width = width;
		this.length = length;
	}
	
	
	
	

}
