package library.sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	// 회원관리
	Connection conn;
	PreparedStatement psmt;
	PreparedStatement psmt2;
	ResultSet rs;
	ResultSet rs2;

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
			if(rs2 != null)
				rs2.close();				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// (1)회원등록
	boolean addMember(Member mem) {
		getConn();
		String sql = "insert into lib_member(mem_id, mem_name, mem_phone) values(?,?,? ) ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getMemId());
			psmt.setString(2, mem.getMemName());
			psmt.setString(3, mem.getMemPhone());

			int r = psmt.executeUpdate(); // db에 처리된 건수를 반환
			if (r == 1) {
				return true; // db에 정상적으로 한 건이 반환된다면~true
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return false;
	}// end of addMember


	// (2)회원정보조회
	Member getMember(String id) { //연체여부, 등급표시 남음
		getConn();		

		String sql = "select mem_id, mem_name, mem_phone, overDue, mem_level from lib_member where mem_id LIKE '%'||?||'%' order by 1 ";
		String sql2 = "select count(*) from book_history where mem_id LIKE '%'||?||'%' ";
		
		try {			
			psmt = conn.prepareStatement(sql);
			psmt2 = conn.prepareStatement(sql2);
			psmt.setString(1, id);
			psmt2.setString(1, id);
			rs = psmt.executeQuery();
			rs2 = psmt2.executeQuery();
			Member member = new Member();
			if (rs.next() ) {
				member.setMemId(rs.getString("mem_id"));
				member.setMemName(rs.getString("mem_name"));			
				member.setMemPhone(rs.getString("mem_phone"));	
				member.setOverDue(rs.getString("overDue"));
				member.setMemLevel(rs.getString("mem_level"));
			} 
			if(rs2.next()) {				
				member.setCheckOut(rs2.getInt("count(*)"));
			}
			return member;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return null;
	}// end of getMember

	// (3)회원대출내역
	ArrayList<BookHistory> getMemHistory(String id) { //
		getConn();
		ArrayList<BookHistory> historys = new ArrayList<>();

		String sql = "select h.out_return, h.hst_date, h.code , b.title "
				+ "from book_history h, book b "
				+ "where h.code = b.code(+) "
				+ "and h.mem_id LIKE '%'||?||'%' ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookHistory history = new BookHistory();
				history.setOutReturn(rs.getString("out_return"));
				history.setHstDate(rs.getString("hst_date"));
				history.setBookCode(rs.getString("code"));
				history.setBookTitle(rs.getString("title"));
				historys.add(history);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return historys;
	}//getMemHistory
	

	// (4)회원수정
	boolean modifyMember(String id, String phone) {
		getConn();
		String sql = "update lib_member set mem_phone=? where mem_id LIKE '%'||?||'%' ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			psmt.setString(2, id);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return false;
	}

	// (5)회원삭제
	boolean removeMember(String id) {
		getConn();
		String sql = "delete from lib_member where mem_id=? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return false;		
	}//end of romoveMember	


}// end of class
