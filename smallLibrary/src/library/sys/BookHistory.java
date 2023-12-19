package library.sys;

import lombok.Data;

@Data
public class BookHistory {
	private String outReturn;
	private String hstDate;
	private String bookCode;
	private String bookTitle;
	
	BookHistory(){
		
	}
	
	
	public BookHistory(String outReturn, String hstDate, String bookCode, String bookTitle){
		this.outReturn = outReturn;
		this.hstDate = hstDate;
//		this.memId = memId;
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
	}
	
	public BookHistory(String outReturn, String hstDate, String bookCode){
		this.outReturn = outReturn;
		this.hstDate = hstDate;
		this.bookCode = bookCode;
	}
	
	void showHst() {
		System.out.println(outReturn+ "	" + hstDate +"	" + bookCode + "	" + bookTitle);
	}
	
	
}//end of class
