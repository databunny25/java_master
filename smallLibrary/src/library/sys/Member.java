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
	public Member(String memId, String memName) {
		this.memId = memId;
		this.memName = memName;
	}
	
	
	public Member(String memId, String memName, String memPhone) {
		this.memId = memId;
		this.memName = memName;
		this.memPhone = memPhone;
	}
	
	public Member(String memId, String memName, int checkOut, String overDue, String memLevel) {
		this.memId = memId;
		this.memName = memName;
		this.checkOut = checkOut;
		this.overDue = overDue;
		this.memLevel = memLevel;
	}
	
	void showInfo() {
		System.out.println(memId +"	" + memName+"	"  + memPhone);
	}
	
	void showMems() {
		System.out.println(memId +"	" + memName +"	"+ checkOut +"	" + overDue + "권" +"	" + memLevel);
	}
	
	void showName() {
		System.out.println(memId + " " + memName);
	}
	
	
}//end of class
