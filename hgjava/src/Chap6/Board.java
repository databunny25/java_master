package Chap6;
	//게시판(게시글번호/제목/작성자/내용/작성일시)
public class Board {
	// 속성(필드)
	private int no;
	private String title;
	private String user;
	private String contents ;
	private String date;
	
	//배열
	private Board[] boards;
	
	//생성자
	
	public Board(int no, String title, String user, String contents, String date) {
			this.no = no;
			this.title = title;
			this.user = user;
			this.contents = contents;
			this.date = date;
	}
	
	
	//기능 (메소드)
	
	boolean addBoard(Board boa) {
		for( int i=0; i < boards.length; i++) {
			if(boards[i] == null) {
				boards[i] = boa;
				return true;
				
			}
		}
		return false;
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
