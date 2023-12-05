package todo.p20231205;

import java.util.ArrayList;
import java.util.List;

public class BookExe {
	
		
//	private List<Book> books; 이렇게 해도 상관없다~
	private ArrayList<Book> books;

	BookExe(){
		books = new ArrayList<Book>();
		books.add(new Book("B001", "이것이자바다", "신용권", "한빛미디어", 25000));
	}
	
	// 1.등록
	
	
	boolean addBook(Book bookbook) {
		return books.add(bookbook); //boolean이니까 이게 잘되면 true를 리턴해준다~
		
	}

	// 2.목록
	
	
	ArrayList<Book> getBookList() {
		return books;
	}

	// 번외. 단건조회
	Book getBook(String code) {
		for(int i=0; i<books.size(); i++) {
			if(books.get(i) !=null && books.get(i).getBookCode().equals(code)) {
				return books.get(i);
			}
		}
		return null;
	}
	
	
	// 3. 수정
	boolean modifyPrice(String code, int inputPrice) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) != null && books.get(i).getBookCode().equals(code)) {

				books.get(i).setPrice(inputPrice);
				return true;
			}
		}
		return false;
	}

	// 4. 삭제
	boolean removeBook(String code) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) != null && books.get(i).getBookCode().equals(code)) {
				books.remove(i);
				return true;
			}
		}
		return false;
	}

}// end of class