package kr.or.javalevel;

/*
 * 완성형 모델 구조(자바 빈 클래스)
*/
public class Total {
	private int orderId;
	private int customId;
	private String customName;
	private int productId;
	private String productName;

	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getCustomId() {
		return customId;
	}
	
	public void setCustomId(int customId) {
		this.customId = customId;
	}
	
	public String getCustomName() {
		return customName;
	}
	
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName; 
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}


