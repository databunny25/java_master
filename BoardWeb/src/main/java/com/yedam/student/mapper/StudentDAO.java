package com.yedam.student.mapper;
//저장공간 : Oracle DB

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.student.vo.Student;

//JDBC 배열로 해보기
//추가 수정 삭제 목록 단건조회
public class StudentDAO {
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
	
	//목록
	public List<Student> getStudentList() {
		getConn();
		List<Student> students = new ArrayList<>();
		String sql = "select * from student order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentNumber(rs.getString("student_number"));
				student.setStudentName(rs.getString("student_name"));
				student.setEnglishScore(rs.getInt("english_score"));
				student.setMathmaticScore(rs.getInt("mathmatic_score"));
				
				students.add(student);
				
				//배열의 빈곳에 한건 저장
//				for (int i = 0; i < students.length; i++) {
//					if(students[i]==null) {
//						students[i] = student;
//						break; //for 반복문 종료
//					}
				}//end of while
				
					
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return students;
	}//end of getStudentList()
	
	
	//추가
	public boolean addStudent(Student std) {
		getConn();
		String sql = "insert into student values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  std.getStudentNumber());
			psmt.setString(2, std.getStudentName());
			psmt.setInt(3, std.getEnglishScore());
			psmt.setInt(4,  std.getMathmaticScore());
			
			int r = psmt.executeUpdate(); //db에 처리된 건수를 반환
			if (r==1) {
				return true; //db에 정상적으로 한 건이 반환된다면~true
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end of addStudent
	
	
	//단건조회
	public Student getStudent(String sno) {
		getConn();
		String sql = "select * from student where student_number = ?"; // ?를 ""로 묶으면 안된다! 그냥 ? 로 씀
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno); //위에 ? 한개에 넣겠다 ...1번째 파라미터에 sno값을 넣겠다!
			rs = psmt.executeQuery();
			if(rs.next()) {
				Student student = new Student();
				student.setStudentNumber(rs.getString("student_number"));
				student.setStudentName(rs.getString("student_name"));
				student.setEnglishScore(rs.getInt("english_score"));
				student.setMathmaticScore(rs.getInt("mathmatic_score"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; //조회된 값이 없으면 null 값 반환
	}//end of getStudent
	
	
	//수정
	public boolean modifyStudent(String no, int eng, int mat) {
		getConn();
		String sql = "update student "
				+ "   set english_score =? "
				+ "   ,mathmatic_score =? "
				+ "   where student_number =? ";
		
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1,  eng);
			psmt.setInt(2,  mat);
			psmt.setString(3,  no);
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}//end of modifyStudent
	
	
	//삭제
	public boolean removeStudent(String name) {
		getConn();
		String sql = "delete from student "
				+ "where student_name =? ";
				
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;				
	
	}//end of removeStudent
	
	
}//end of class
