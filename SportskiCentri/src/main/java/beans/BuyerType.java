package beans;

public class BuyerType {
	
	
	public static final int goldPoints=3000;
	public static final int silverPoints=2000;
	public static final int bronzePoints=1000;
	public static final double goldDiscount=10;
	public static final double silverDiscount=7.5;
	public static final double bronzeDiscount=5.0;
	
	private BuyerRank buyerRank;
	private double discount;
	
	
	
	
	public BuyerType(BuyerRank buyerRank, double discount) {
		super();
		this.buyerRank = buyerRank;
		this.discount = discount;
	}
	
	
	
	public BuyerRank getBuyerRank() {
		return buyerRank;
	}
	public void setBuyerRank(BuyerRank buyerRank) {
		this.buyerRank = buyerRank;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public static int getGoldpoints() {
		return goldPoints;
	}
	public static int getSilverpoints() {
		return silverPoints;
	}
	public static int getBronzepoints() {
		return bronzePoints;
	}
	public static double getGolddiscount() {
		return goldDiscount;
	}
	public static double getSilverdiscount() {
		return silverDiscount;
	}
	public static double getBronzediscount() {
		return bronzeDiscount;
	}

	
	
	

}
