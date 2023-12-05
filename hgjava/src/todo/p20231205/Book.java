package todo.p20231205;

import lombok.Data;

@Data
public class Book {
	private String bookCode;
	private String bookTitle;
	private String author;
	private String publisher;
	private int price;
	
	Book(){
		
	}
	
	public Book(String bookCode, String bookTitle, String author, String publisher, int price) {
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	void showInfo() {
		System.out.println(bookCode + " " +bookTitle  + " " + author + " "+ price);
	}
	
//	String showInfo() {
//		String result = bookCode + " " +bookTitle  + " " + author + " "+ price;
//		return result;
//	}
		
	
	
}//end of class
