package chap11.object;

public class Member {
	private String name;
	private int age;

	Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		// 논리적으로 동등한 객체(이름, 나이) (이름과 나이가 같으면 논리적으로 동등한 객체로 보겠습니다~라는 코드 만들기)
		if (obj instanceof Member) {
			Member target = (Member) obj;
			if (this.name.equals(target.name) && this.age == target.age) {
				return true;
			}

		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}//name을 해쉬코드 값으로 받도록 우리가 지정해봄!
	
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}

}
