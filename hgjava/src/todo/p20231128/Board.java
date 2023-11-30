package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data


//게시판(게시글번호/제목/작성자/내용/작성일시)
public class Board {
	// Board 클래스 : 주로 데이터 한건한건을 담아두기 위한 용도, 필드의 값을 채워넣거나 가져오거나~
	// 속성(필드)
	private int no;
	private String title;
	private String user;
	private String contents ;
	private String date;
	
	//배열
	private Board[] boards;
	
	//생성자
	
	public Board(int no, String title, String user, String contents) {
			Date today = new Date(); //시스템시간을 기준으로 생성
			
			//Date -> String -> Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
			this.no = no;
			this.title = title;
			this.user = user;
			this.contents = contents;
			this.date = sdf.format(today);
	}
	
	public Board(int no, String title, String user, String contents, String date) {
//			this(); //기본생성자.
			this(no, title, user, contents);
			this.date = date;
	}
	
	
	//기능 (메소드)
//	
//	boolean addBoard(Board boa) {
//		for( int i=0; i < boards.length; i++) {
//			if(boards[i] == null) {
//				boards[i] = boa;
//				return true;
//				
//			}
//		}
//		return false;
//	}
	
	public String showInfo() {
		return no + " " + title + " " + user + " " + date;
	}
	
	public String showDetailInfo() {
//		번호 : 1 / 제목: 자바게시판입니다
//		작성자: user01
//		내용: 오늘은 숙제로 자바게시판을 만들어봅시다.
//		일시: 2023-11-28
		String result = "번호: " + no + "/ 제목: " + title;
		result += "\n작성자: " + user;
		result += "\n내용: " + contents;
		result += "\n일시: " + date;
		return result;
	}
	
	
	// setter

	public void setNo(int no) {
		this.no = no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setDate(String date) {
		this.date = date;
	}


	//getter
	

	public int getNo() {
		return no;
	}


	public String getTitle() {
		return title;
	}


	public String getUser() {
		return user;
	}


	public String getContents() {
		return contents;
	}


	public String getDate() {
		return date;
	}
	
	
			
}//end of class
