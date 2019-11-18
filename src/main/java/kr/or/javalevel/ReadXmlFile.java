package kr.or.javalevel;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXmlFile {
	//절대경로 지정
	//private String rootFile = System.getProperty("user.dir") + File.separator + "info" + File.separator ;
	//상대경로 지정
	private String rootFile = "." + File.separator + "info" + File.separator ;
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
		this.totalManager = totalManager;
	}

	public void ReadXml(String fileName) {
		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(rootFile + fileName));
			document.getDocumentElement().normalize();
			NodeList nodeList = null;
			
			//파일을 읽었을때 사용된 목적이 무엇인지 알기위해 루트 태그를 읽어와 타입을 결정한다.
			if(document.getDocumentElement().getNodeName().contains("customer")) {
				setType(ClassType.CUSTOMER);
				nodeList = document.getElementsByTagName("customerInfo");
			}
			else if(document.getDocumentElement().getNodeName().contains("order")) {
				setType(ClassType.ORDER);
				nodeList = document.getElementsByTagName("orderInfo");
			}
			else if(document.getDocumentElement().getNodeName().contains("product")) {
				setType(ClassType.PRODUCT);
				nodeList = document.getElementsByTagName("productInfo");
			}
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elemnet = (Element) node;
					
					if(getType() == ClassType.CUSTOMER) {
						Customer obj = new Customer();
						obj.setCustomId(elemnet.getElementsByTagName("customerId").item(0).getTextContent());
						obj.setCustomName(elemnet.getElementsByTagName("customerName").item(0).getTextContent());
						//핸들러 클래스에 저장된 Map에 저장시킨다.
						getTotalManager().getCustomMap().put(obj.getCustomId(), obj);
					}
					else if(getType() == ClassType.ORDER) {
						Order obj = new Order();
						obj.setOrderId(elemnet.getElementsByTagName("orderId").item(0).getTextContent());
						obj.setCustomId(elemnet.getElementsByTagName("customerId").item(0).getTextContent());
						obj.setProductId(elemnet.getElementsByTagName("productId").item(0).getTextContent());
						//핸들러 클래스에 저장된 리스트에 저장시킨다.
						getTotalManager().getOrderList().add(obj);
					}
					else if(getType() == ClassType.PRODUCT) {
						Product obj = new Product();
						obj.setProductId(elemnet.getElementsByTagName("productId").item(0).getTextContent());
						obj.setProductName(elemnet.getElementsByTagName("productName").item(0).getTextContent());
						//핸들러 클래스에 저장된 Map에 저장시킨다.
						getTotalManager().getProductMap().put(obj.getProductId(), obj);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}




	}

}

