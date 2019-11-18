package kr.or.javalevel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadCsvFile {
	//절대경로 지정
	//private String rootFile = System.getProperty("user.dir") + File.separator + "info" + File.separator ;
	//상대경로 지정
	private String rootFile = "." + File.separator + "info" + File.separator; //
	private ClassType type = ClassType.NONE;
	private TotalManager totalManager;

	public String getRootFile() {
		return rootFile;
	}

	public void setRootFile(String rootFile) {
		this.rootFile = rootFile;
	}

	public ClassType getType() {
		return type;
	}

	public void setType(ClassType type) {
		this.type = type;
	}

	public TotalManager getTotalManager() {
		return totalManager;
	}

	public void setTotalManager(TotalManager totalManager) {
		//핸들러 클래스의 레퍼런스는 단한개 존재해야된다.
		this.totalManager = totalManager;
	}

	public void readCsv(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(rootFile + fileName));
			String line = "";
			int col  = 0;
			while ((line = br.readLine()) != null){
				String array[] = line.split(",");
				
				//파일을 읽었을때 사용된 목적이 무엇인지 알기위해 첫번째 컬럼(기본키)를 읽어와 타입을 결정한다.
				if (col == 0) {		
					col++;
					if (array[0].contains("고객")) {
						setType(ClassType.CUSTOMER);
					}
					else if (array[0].contains("주문")) {
						setType(ClassType.ORDER);
					}
					else if (array[0].contains("상품")) {
						setType(ClassType.PRODUCT);
					}
					continue;
				}  

				//2행 부터 값영역
				if (getType() == ClassType.CUSTOMER) { 
					Customer obj = new Customer();
					obj.setCustomId(array[0]);
					obj.setCustomName(array[1]);
					//핸들러 클래스에 저장된 Map에 저장시킨다.
					getTotalManager().getCustomMap().put(obj.getCustomId(), obj);
				}
				else if (getType() == ClassType.ORDER) { 
					Order obj = new Order();
					obj.setOrderId(array[0]);
					obj.setCustomId(array[1]);
					obj.setProductId(array[2]);
					//핸들러 클래스에 저장된 Map에 저장시킨다.
					getTotalManager().getOrderList().add(obj);
				}
				else if (getType() == ClassType.PRODUCT) { 
					Product obj = new Product();
					obj.setProductId(array[0]);
					obj.setProductName(array[1]);
					//핸들러 클래스에 저장된 Map에 저장시킨다.
					getTotalManager().getProductMap().put(obj.getProductId(), obj);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
