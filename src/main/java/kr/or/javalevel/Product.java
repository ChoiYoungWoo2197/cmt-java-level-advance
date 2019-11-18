package kr.or.javalevel;

/*
 * 상품 모델(자바 빈 클래스)
*/
public class Product {
	//기본키
	private int productId;
	//값
    private String productName;
    
    public int getProductId() {
		return productId;
	}
    
	public void setProductId(String productId) {
		setProductId(Integer.parseInt(productId));
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
