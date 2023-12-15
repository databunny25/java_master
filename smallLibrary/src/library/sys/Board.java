package library.sys;

public class Board {

	private int bNo;
	private String bWriter;
	private String bTitle;
	private String bContent;
	private String bDate;
	
	Board(){
		
	}
	
	public Board(int bNo, String bWriter, String bTitle, String bContent, String bDate) {
		this.bNo = bNo;
		this.bWriter = bWriter;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		
	}
	
}
