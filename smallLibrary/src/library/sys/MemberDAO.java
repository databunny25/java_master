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

	// (2)회원목록
	ArrayList<Member> getMemberList() {
		getConn();
		ArrayList<Member> members = new ArrayList<>();

		String sql = "select * from lib_member order by 1";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setMemId(rs.getString("mem_id"));
				member.setMemName(rs.getString("mem_name"));
				member.setMemPhone(rs.getString("mem_phone"));
				members.add(member);
			} // end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return members;
	}// end of getMemberList

	// (3)회원정보조회
	ArrayList<Member> getMember(String name) {
		getConn();
		ArrayList<Member> members = new ArrayList<>();

		String sql = "select mem_id, mem_name, checkOut, overDue, mem_level from lib_member where mem_name LIKE '%'||?||'%' order by 1";
		String sql2 = "select COUNT(h.code) from lib_member m, book_history h where m.mem_id = h.mem_id ";
		//조인하고...count해줘야함.....!!!!!ㅠㅠ
		try {			
			psmt = conn.prepareStatement(sql);
			psmt2 = conn.prepareStatement(sql2);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			rs2 = psmt2.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setMemId(rs.getString("mem_id"));
				member.setMemName(rs.getString("mem_name"));
				member.setCheckOut(rs2.getInt("checkOut"));
				member.setOverDue(rs.getString("overDue"));
				member.setMemLevel(rs.getString("mem_level"));
				members.add(member);
			} // end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return members;
	}// end of getBookList

	// (4)회원대출내역
	Member getMemberName(String id) {		
		getConn();		
		String sql = "select mem_id, mem_name from lib_member where mem_id LIKE '%'||?||'%' ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				Member memName = new Member();
				memName.setMemId(rs.getString("mem_id"));
				memName.setMemName(rs.getString("mem_name"));
				return memName;
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return null;
	}//getMemberName
	
	ArrayList<BookHistory> getHistory() {
		ArrayList<BookHistory> bookHistory = new ArrayList<>();
		getConn();

		String sql = "select h.hst_date, h.code, b.title from book_history h, book b where h.code = b.code and h.out_return = '대출' and h.code =? ";
		String sql2 = "select hst_date from book_history where code = ? and out_return = '반납'";

		try {
			psmt = conn.prepareStatement(sql);
			psmt2 = conn.prepareStatement(sql2);
			rs = psmt.executeQuery();
			rs2 = psmt.executeQuery();
			while (rs.next()) {
				BookHistory history = new BookHistory();
				history.setOutDate(rs.getString("h.hst_date"));
				history.setReturnDate(rs2.getString("hst_date"));
				history.setBookCode(rs.getString("h.code"));
				history.setBookTitle(rs.getString("b.title"));
				bookHistory.add(history);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}		
		return bookHistory;
	}// end of getHistory

	// (5)회원수정
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

	// (6)회원삭제
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
