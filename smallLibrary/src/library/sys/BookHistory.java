package library.sys;

import lombok.Data;

@Data
public class BookHistory {
	private String outDate;
	private String returnDate;
	private String bookCode;
	private String bookTitle;
	
	BookHistory(){
		
	}
	
	//대출만 한 경우
	public BookHistory(String outDate, String bookCode, String bookTitle){
		this.outDate = outDate;
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
	}
	//대출하고 반납한 경우
	public BookHistory(String outDate, String returnDate, String bookCode, String bookTitle){
		this.outDate = outDate;
		this.returnDate = returnDate;
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
	}
	
	void showHst() {
		System.out.println(outDate+ "	" + returnDate + "	"+ bookCode +"	" + bookTitle);
	}
	
	
}//end of class
