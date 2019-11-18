package kr.or.javalevel;

/*
 * 고객 모델(자바 빈 클래스)
*/
public class Customer {
	//기본키
    private int customId;
    //값
    private String customName; 
	
    public int getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		setCustomId(Integer.parseInt(customId));
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
    
}
