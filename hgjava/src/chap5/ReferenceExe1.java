package chap5;

// 복합적인 형태의 데이터 구조.
class Friend {
	String name; //필드
	int age; //필드
	double height; //필드
	
	
}

public class ReferenceExe1 {
	public static void main(String[] args) {
		
		// 참조변수: 실제값을 담는것(X) -> 실제값의 '주소'를 담고있다!(O)
		Friend myFriend = new Friend(); // new => 객체 생성
		myFriend.name = "김철수";
		myFriend.age = 20;
		myFriend.height = 178.3;
		
//		Friend ourFriend = myFriend;
//		
//		myFriend.name = "홍길동";
//		
//		
//		System.out.println(ourFriend.name); 
//		System.out.println(ourFriend.age); 
//		System.out.println(ourFriend.height); 
		
		Friend yourFriend = new Friend(); // new => 객체 생성
		yourFriend.name = "김철수";
		yourFriend.age = 20;
		yourFriend.height = 178.3;
		
		System.out.println(myFriend == yourFriend); //주소값 비교: false (김철수로 값은 같지만 주소값이 다르므로 항상 false!!!)
		
		yourFriend = null;
		System.out.println(myFriend.name);
		try {
		System.out.println(yourFriend.name); //NullPointerException 발생~ => 예외처리 해줌!
		} catch (Exception e) {
			System.out.println("null값을 참조합니다.");
		}
		
		
		//기본타입.
		int a = 10;
		int b = a;
		
		a = 20;
		
		//참조타입: 주소값을 변수에 저장.
		
		String name = new String("신용권"); // 23dbdae34334 라는 주소값을 가짐 주소를 따라가면 신용권이라는 객체를 보여줌
		String hobby = "독서"; //
		
		String name1 = new String("신용권"); //클래스 선언처럼 string을 선언하면 주소값이니까 false
		String hobby1 = "독서"; //string은 많이 쓰니까~이렇게 선언하면 equals비교시 true
		System.out.println("name: " + name);
		System.out.println("name1: " + name1);
		
		System.out.println(name == name1); // == -> equals 메소드 활용!
		System.out.println(hobby == hobby1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
