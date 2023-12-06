package todo.p20231206;

import java.util.ArrayList;

public class ProductExe {
	private ArrayList<Product> products;
	
	ProductExe(){
		products = new ArrayList<Product>();
		products.add(new Product("P001", "볼펜", 1000));
		products.add(new Product("P002", "연필", 1200));
		products.add(new Product("N001", "노트100", 1000));
		products.add(new Product("N002", "다이어리", 3000));
	}
	
	//1-1)등록
	boolean addProduct(Product product) {
		return products.add(product);
	}
	
	//1-2)수정
	boolean modifyProduct(String code, int price) {
		for(int i=0; i<products.size(); i++) {
			if(products.get(i) != null && products.get(i).getProductCode().equals(code)) {
				products.get(i).setProductPrice(price);
				return true;
			}
		}
		return false;
	}
	
	//1-3)목록
	ArrayList<Product> getProductList(){
		return products;
	}
	
}//end of class
