package todo.p20231206;

import java.util.ArrayList;

public class InOutExe {
	private ArrayList<InOut> inOuts;

	InOutExe() {
		inOuts = new ArrayList<InOut>();
		inOuts.add(new InOut("P001", "2023-12-06", 10, "구매"));
		inOuts.add(new InOut("P001", "2023-12-06", 2, "판매"));
		inOuts.add(new InOut("P001", "2023-12-06", 3, "판매"));
		inOuts.add(new InOut("P002", "2023-12-06", 10, "구매"));
		inOuts.add(new InOut("P002", "2023-12-06", 2, "판매"));
		inOuts.add(new InOut("P002", "2023-12-06", 4, "판매"));
	}

	// 2-1)판매
	boolean addInOut(InOut inOut) {
		return inOuts.add(inOut);
	}

	// 2-2)구매
	boolean subtractInOut(InOut inOut) {
		return inOuts.add(inOut);
	}

	// 2-3)재고
	void getInOutList() {
		ProductExe productExe = new ProductExe();
		ArrayList<Product> list = productExe.getProductList();

		for (int i = 0; i < list.size(); i++) {
			Product product = list.get(i);
			int qty = 0;
			for (int j = 0; j < inOuts.size(); j++) {
				InOut inOut = inOuts.get(j);
				if (product.getProductCode().equals(inOut.getProductCode())) {
					qty += (inOut.getInOut().equals("구매")) ? inOut.getInOutNum() : inOut.getInOutNum() * -1;
				}
			}
			System.out.println(product.getProductCode() + " : " + qty);
		}
	}

}// end of class

