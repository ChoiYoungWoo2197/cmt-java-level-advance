package kr.or.javalevel;

/*
 * 주문 모델(자바 빈 클래스)
*/
public class Order {
	//기본키
	private int orderId;
	//외래키
	private int customId;
	//외래키
	private int productId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		setOrderId(Integer.parseInt(orderId));
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		setCustomId(Integer.parseInt(customId));
	}

	public void setCustomId(int customId) {
		this.customId = customId;
	}

	public int getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		setProductId(Integer.parseInt(productId));
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}

}
