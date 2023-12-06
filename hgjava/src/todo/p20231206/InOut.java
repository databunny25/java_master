package todo.p20231206;

import lombok.Data;

@Data
public class InOut {
	private String productCode;
	private String inOutDate;
	private int inOutNum;
	private String inOut;

	InOut() {

	}

	public InOut(String productCode, String inOutDate, int inOutNum, String inOut) {
		this.productCode = productCode;
		this.inOutDate = inOutDate;
		this.inOutNum = inOutNum;
		this.inOut = inOut;
	}
	
	void showInfo() {
		System.out.println(productCode + " "+  inOutDate + " " + inOutNum + " "+ inOut);
	}
	

}
