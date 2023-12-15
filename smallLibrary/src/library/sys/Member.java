package library.sys;

import lombok.Data;

@Data
public class Member {
	
	private String memId;
	private String memName;
	private String memPhone;
	private String memLevel;
	
	Member(){
	
	}
	
	public Member(String memId, String memName, String memPhone, String memLevel) {
		this.memId = memId;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memLevel = memLevel;
	}
	
	
	
	
}//end of class
