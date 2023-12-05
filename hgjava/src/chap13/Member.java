package chap13;

import lombok.Data;

@Data
public class Member {
	private String memberNo;
	private String memberName;
	private int point;
	
	public Member(String memberNo, String memberName, int point) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.point = point;
	}
	
	//hashCode, equals 정의하는 지에 따라서 동일객체
//	@Override
//	public int hashCode() {
//		return super.hashCode(); //부모(Object) 가 가진 해쉬코드 메소드로 해쉬코드 정의 ...해쉬코드가 다르면 논리적으로 다른 객체다라고 정의한 것!
//	}//이게 없으면 MapExe2에서 키 값이 같으면 같은 값으로 생각한다!
	
	
	
	
	
}
