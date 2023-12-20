package todo.p20231214;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//JDBC ListArray로 해보기
public class BookDAO {
	
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//1.등록
	
	boolean addBook(Book book) {
		getConn();
		String sql = "insert into book values(?,?,?,?,?)";
		
		try {
			conn.setAutoCommit(false);//자동커밋 실행 여부
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  book.getBookCode());
			psmt.setString(2,  book.getBookTitle());
			psmt.setString(3,  book.getAuthor());
			psmt.setString(4,  book.getPublisher());
			psmt.setInt(5,  book.getPrice());
						
			int r = psmt.executeUpdate();
			if (r==1) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end of addBook
	
	//2.목록
	ArrayList<Book> getBookList() {
		getConn();
		ArrayList<Book> books = new ArrayList<>();
		
		String sql = "select * from book order by 1";		
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("book_code"));
				book.setBookTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				books.add(book);
				
			}//end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}//end of getBookList
	
	
	//3.단건조회
	Book getBook(String bookCode) {
		getConn();
		String sql = "select * from book where book_code=? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("book_code"));
				book.setBookTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
	
	//4.수정
	boolean modifyBook(String code, int price) {
		getConn();
		String sql = "update book set price=? where book_code=? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, price);
			psmt.setString(2, code);
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//5.삭제
	boolean removeBook(String code) {
		getConn();
		String sql = "delete from book where book_code=? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end of removeBook
	
	// 어레이리스트, 페이지 => 페이지의 5건을 반환
	public static ArrayList<Book> pageList(ArrayList<Book> ary, int page){
		ArrayList<Book> resultAry = new ArrayList<>;
		
		int start = (page - 1) *5;
		int end = page*5
		int j= 0;
		for(int i=0; i<ary.size(); i++) {
			if(i>=start && i<end) {
				resultAry<j++> = ary<i>;
			}
		}
		return resultAry;
	}//end of pageList
	
	
	//6.종료
	
	
}//end of class
