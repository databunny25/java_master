package todo.p20231206;

import lombok.Data;

@Data
public class Product {
	String productCode;
	String productName;
	int productPrice;

	Product() {

	}

	public Product(String productCode, String productName, int productPrice) {
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	void showInfo() {
		System.out.println(productCode + " " + productName + " " + productPrice);
	}

}// end of class