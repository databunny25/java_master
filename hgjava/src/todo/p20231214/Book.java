package todo.p20231214;

public class Book {
	private String bookCode;
	private String bookTitle;
	private String author;
	private String publisher;
	private int price;

	Book() {

	}

	public Book(String bookCode, String bookTitle, String author, String press, int price) {
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	// 메소드 정의.
	void showInfo() {
		System.out.println(bookCode + "   " + bookTitle + "   " + author + "   " + price);
	}

	String getBookCode() {
		return bookCode;
	}

	void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	String getBookTitle() {
		return bookTitle;
	}

	void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	String getAuthor() {
		return author;
	}

	void setAuthor(String author) {
		this.author = author;
	}

	String getPublisher() {
		return publisher;
	}

	void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	int getPrice() {
		return price;
	}

	void setPrice(int price) {
		this.price = price;
	}

}
