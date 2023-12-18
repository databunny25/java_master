package library.sys;

import lombok.Data;

@Data
public class Book {
	String code;
	String title;
	String author;
	String publisher;
	String valid;
	
	Book(){
		
	}
	
	Book(String code, String title, String author, String publisher, String valid){
		this.code = code;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.valid = valid;
	}
	
	void showBook(){
		System.out.println(code + "	" + title+ "	"  + author+ "	"+ publisher+ "	"  + valid);
	}
	
}//end of class
