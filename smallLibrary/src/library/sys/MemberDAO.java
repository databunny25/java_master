package library.sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	//회원관리
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
	
	//(1)회원등록 
	boolean addMember(Member mem) {
		getConn();
		String sql = "insert into student values(?,?,?)";
		try {
			conn.setAutoCommit(false);
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  mem.getMemId());
			psmt.setString(2, mem.getMemName());
			psmt.setString(3, mem.getMemPhone());
			
			int r = psmt.executeUpdate(); //db에 처리된 건수를 반환
			if (r==1) {
				return true; //db에 정상적으로 한 건이 반환된다면~true
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}//end of addMember	
	
	//(2)회원목록 
	ArrayList<Member> getMemberList() {
		getConn();
		ArrayList<Member> members = new ArrayList<>();
		
		String sql = "select * from member order by 1";		
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setMemId(rs.getString("mem_id"));
				member.setMemName(rs.getString("mem_name"));
				member.setMemPhone(rs.getString("mem_phone"));
				members.add(member);				
			}//end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}//end of getMemberList
		
	//(3)회원정보조회 
	ArrayList<Member> getMember() {
		getConn();
		ArrayList<Member> members = new ArrayList<>();
		
		String sql = "select * from member where mem_name LIKE '%'||?||'%' order by 1";		
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setMemId(rs.getString("mem_id"));
				member.setMemName(rs.getString("mem_name"));
				member.setMemPhone(rs.getString("mem_phone"));
				members.add(member);				
			}//end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}//end of getBookList
	
	//(4)회원대출내역 
	//(5)회원수정 
	//(6)회원삭제 
	//(7)회원등급기준
	
	
}//end of class
