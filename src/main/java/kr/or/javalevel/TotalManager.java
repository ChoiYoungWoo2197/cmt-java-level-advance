package kr.or.javalevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/*
 * total클래스의 정보를 다루는 핸들러 클래스는 단 한개의 객체만 존재하여야 한다.
 * 객체를 다루는데 필요한 메서드, 필드 선언
*/
public class TotalManager {

	private TotalManager totalManager;
	//데이터 취합
	private List<Total> totalList = new ArrayList<Total>();
	private List<Order> orderList = new ArrayList<Order>();
	private Map<Integer, Customer> customMap = new HashMap<Integer, Customer>();
	private Map<Integer, Product> productMap = new HashMap<Integer, Product>();
	
	public TotalManager getTotalManager() {
		return totalManager;
	}

	public void setTotalManager(TotalManager totalManager) {
		this.totalManager = totalManager;
	}
	
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public Map<Integer, Customer> getCustomMap() {
		return customMap;
	}

	public void setCustomMap(Map<Integer, Customer> customMap) {
		this.customMap = customMap;
	}

	public Map<Integer, Product> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<Integer, Product> productMap) {
		this.productMap = productMap;
	}

	public List<Total> getTotalArray() {
		return totalList;
	}

	public void setTotalList(List<Total> totalList) {
		this.totalList = totalList;
	}
	
	//데이터 취합 하는 함수
	public List<Total> mergeValue(Map<Integer, Customer> customMap, Map<Integer, Product> productMap ,List<Order> orderList) {
		/*
		   테이블 관계도 
		   고객  : 주문 > 1 : N
		   상품 : 주문 > 1: N 
		*/
		List<Total> tmpList = new ArrayList<Total>();
		
		for (int i = 0; i < orderList.size(); i++) {
			Total total = new Total();
			int orderId = orderList.get(i).getOrderId();
			int customId = orderList.get(i).getCustomId();
			String customName =  customMap.get(customId).getCustomName();
			int productId = orderList.get(i).getProductId();
			String productName = productMap.get(productId).getProductName(); 

			total.setOrderId(orderId);
			total.setCustomId(customId);
			total.setCustomName(customName);
			total.setProductId(productId);
			total.setProductName(productName);
			
			tmpList.add(total);

		}
		
		return tmpList;
	}

	//데이터 출력하는 함수
	public void printValue(List<Total> totalList) {
		String header = String.format("%s : %s : %s : %s : %s", "주문 식별번호",  "고객 식별번호", "고객 이름", "상품 식별번호", "상품명");
		System.out.println(header);

		Iterator<Total> itTotalList = totalList.iterator();
		while (itTotalList.hasNext()) {
			Total obj =  itTotalList.next();
			String str = String.format("%d : %d : %s : %d : %s", obj.getOrderId(), obj.getCustomId(), obj.getCustomName(), obj.getProductId(), obj.getProductName());
			System.out.println(str);
		}
	}
	
	//파일의 확장자를 통해 타입 구분 하는 함수
	public boolean exisitCsvFile(String fileName) {
		boolean rtval = false;
		int pos = fileName.lastIndexOf(".");
		String type = fileName.substring(pos + 1);
	
		if (type.equals("csv") == true) {
			rtval = true;
		}
		else {
			rtval = false;
		}
			
		return rtval;
	}

}
