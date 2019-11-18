package kr.or.javalevel;

public class TotalMain {
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * total 객체에 대해 정보를 다루는 핸들러 클래스 선언 
		 * 단 한번만 실행되게 한다.
		 */
		TotalManager totalManager = new TotalManager();
		totalManager.setTotalManager(totalManager);
		String[] nameFiles = {"customer.xml","order.xml","product.csv"};

		for (int i = 0; i < nameFiles.length; i++) {
			//csv, xml인지 파일확인
			boolean exitCsvType = totalManager.exisitCsvFile(nameFiles[i]);

			//csv파일이라면
			if (exitCsvType == true) {
				ReadCsvFile parseObj = new ReadCsvFile();
				//핸들러 객체를 공유하기 위해 매게변수로 넘겨준다.
				parseObj.setTotalManager(totalManager);
				parseObj.readCsv(nameFiles[i]);
			}
			//xml파일이라면
			else {
				ReadXmlFile parseObj = new ReadXmlFile();
				//핸들러 객체를 공유하기 위해 매게변수로 넘겨준다.
				parseObj.setTotalManager(totalManager);
				parseObj.readXml(nameFiles[i]);
			}

		}

		totalManager.setTotalList(totalManager.mergeValue(totalManager.getCustomMap(), totalManager.getProductMap() ,totalManager.getOrderList())); 
		totalManager.printValue(totalManager.getTotalArray());

	}

}
