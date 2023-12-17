package library.sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
	Connection conn;
	PreparedStatement psmt;
	PreparedStatement psmt2;
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
	
	// (1)도서검색
	Book getBook(String title) {
		getConn();
		String sql = "select * from lib_book where title LIKE '%'||?||'%' ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Book book = new Book();
				book.setCode(rs.getString("code"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setValid(rs.getString("valid"));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// (2)대출
	boolean modifyIn(String memId, String code, String date) {
		getConn();
		String sql_book = "update lib_book set valid = '대출중' where code =?";
		String sql_htr = "insert into book_history values (?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql_book);
			psmt2 = conn.prepareStatement(sql_htr);
			psmt.setString(1, code);
			psmt2.setString(1, "대출");
			psmt2.setString(2, memId);
			psmt2.setString(3, code);
			psmt2.setString(4, date);

			int r = psmt.executeUpdate();
			int s = psmt2.executeUpdate();
			if (r > 0 && s > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end of modifyIn

	// (3)반납
	boolean modifyOut(String memId, String code, String date) {
		getConn();
		String sql_book = "update lib_book set valid = '대출가능' where code =?";
		String sql_htr = "insert into book_history values (?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql_book);
			psmt2 = conn.prepareStatement(sql_htr);
			psmt.setString(1, code);
			psmt2.setString(1, "반납");
			psmt2.setString(2, memId);
			psmt2.setString(3, code);
			psmt2.setString(4, date);

			int r = psmt.executeUpdate();
			int s = psmt2.executeUpdate();
			if (r > 0 && s > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end of modifyOut
		
	// (4)장서목록
	ArrayList<Book> getBookList() {
		getConn();
		ArrayList<Book> books = new ArrayList<>();
		
		String sql = "select * from book order by 1";		
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setCode(rs.getString("code"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setValid(rs.getString("valid"));
				books.add(book);
				
			}//end of while
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}//end of getBookList
	
}
