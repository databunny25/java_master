package chap11.object;

public class ObjectExe {
	public static void main(String[] args) {
		//equals.
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		//객체의 주소값을 비교
		System.out.println(obj1.equals(obj2));
		
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1.equals(str2));
		
		
		//Member에서 내가 재정의한 equals메소드 사용해보기(이름과 나이가 같으면 멤버클래스의 다른 인스턴스여도 같다고 true값을 반환했다!)
		//Member에서 내가 재정의한 equals메소드 사용해보기(이름만 같아도 멤버클래스의 다른 인스턴스여도 같다고 true값을 반환했다!)
		Member mem1 = new Member("홍길동", 22);
		Member mem2 = new Member("홍길동", 19);
		System.out.println(mem1.equals(mem2));
		
	}
}
