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
		String url = "jdbc:oracle:thin:@192.168.0.37:1521:xe";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
//			System.out.println("연결성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	void disconn() {
		try {
			if(conn != null)
				conn.close();
			if(psmt != null)
				psmt.close();
			if(psmt2 != null)
				psmt2.close();
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// (1)도서검색
	ArrayList<Book> getBook(String title) {
		getConn();
		ArrayList<Book> books = new ArrayList<>();

		String sql = "select * from book where title LIKE '%'||?||'%' order by 1 ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setCode(rs.getString("code"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setValid(rs.getString("valid"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return books;
	}

	// (2)대출
	boolean modifyIn(String memId, String code, String date) {
		getConn();
		String sql_book = "update book set valid = '대출중' where code =?";
		String sql_htr = "insert into book_history values (?,NVL(?,sysdate),?,?)";

		try {
			psmt = conn.prepareStatement(sql_book);
			psmt2 = conn.prepareStatement(sql_htr);
			psmt.setString(1, code);
			psmt2.setString(1, "대출");
			psmt2.setString(2, date);
			psmt2.setString(3, memId);
			psmt2.setString(4, code);

			int r = psmt.executeUpdate();
			int s = psmt2.executeUpdate();
			if (r > 0 && s > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return false;
	}//end of modifyIn

	// (3)반납
	boolean modifyOut(String memId, String code, String date) {
		getConn();
		String sql_book = "update book set valid = '대출가능' where code =? ";
		String sql_htr = "insert into book_history values (?,NVL(?,sysdate),?,?) ";

		try {
			psmt = conn.prepareStatement(sql_book);
			psmt2 = conn.prepareStatement(sql_htr);
			psmt.setString(1, code);
			psmt2.setString(1, "반납");
			psmt2.setString(2, date);
			psmt2.setString(3, memId);
			psmt2.setString(4, code);

			int r = psmt.executeUpdate();
			int s = psmt2.executeUpdate();
			if (r > 0 && s > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
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
		}finally {
			disconn();
		}
		return books;
	}//end of getBookList
	
}
