package library.sys;

import lombok.Data;

@Data
public class Member {
	
	private String memId;
	private String memName;
	private String memPhone;
	private int checkOut;
	private String overDue;
	private String memLevel;
	
	Member(){
	
	}
	
	public Member(String memId, String memName, String memPhone, String memLevel) {
		this.memId = memId;
		this.memName = memName;
		this.memPhone = memPhone;
	}
	
	public Member(String memId, String memName, String memPhone, int checkOut, String overDue, String memLevel) {
		this.memId = memId;
		this.memName = memName;
		this.memPhone = memPhone;
		this.checkOut = checkOut;
		this.overDue = overDue;
		this.memLevel = memLevel;
	}
	
	
	
	
}//end of class
