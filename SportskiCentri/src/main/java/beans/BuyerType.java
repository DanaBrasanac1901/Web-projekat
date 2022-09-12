package beans;

public class BuyerType {
	
	
	public static final int goldPoints=3000;
	public static final int silverPoints=2000;
	public static final int bronzePoints=1000;
	public static final int goldDiscount=10;
	public static final int silverDiscount=5;
	public static final int bronzeDiscount=3;
	public static final int no_discount=0;
	
	private BuyerRank buyerRank;
	private int discount;
	
	
	
	
	public BuyerType(BuyerRank buyerRank, int discount) {
		
		this.buyerRank = buyerRank;
		this.discount = discount;
	}
	
	
	
	public BuyerRank getBuyerRank() {
		return buyerRank;
	}
	public void setBuyerRank(BuyerRank buyerRank) {
		this.buyerRank = buyerRank;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
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
	public static int getGolddiscount() {
		return goldDiscount;
	}
	public static int getSilverdiscount() {
		return silverDiscount;
	}
	public static int getBronzediscount() {
		return bronzeDiscount;
	}

	
	
	

}
