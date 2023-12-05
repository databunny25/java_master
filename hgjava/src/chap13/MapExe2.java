package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe2 {
	public static void main(String[] args) {
		Map<Member, String> map;
		map = new HashMap<>(); //map = new HashMap<Member, String>(); 이렇게 써도 되고 생략도 가능하다~
		
		map.put(new Member("M001", "홍길동", 100), "경기도 100번지"); //new Member이렇게 인스턴스 만들면 주소값을 반환한다~
		map.put(new Member("M002", "김민수", 90), "서울시 200번지");
		map.put(new Member("M003", "박씨", 80), "대전시 300번지");
		map.put(new Member("M001", "홍길동", 100), "경기도 200번지");
		
		map.remove(new Member("M001", "홍길동", 100));
		
		
		// 1) key를 set에 저장 (key값들을 set에 저장하겠다)
		Set<Member> set = map.keySet(); //set컬렉션은 중복된 값은 담아주지 않는다!
		for(Member member:set) {
			System.out.println("key: " + member+ ", value: " + map.get(member));
		}
		
		// 2) key, value ==> set에 저장
		Set<Entry<Member, String>> entry = map.entrySet();
		for(Entry<Member, String> ent : entry) {
			System.out.println("key: "+ ent.getKey() + ", Val: " + ent.getValue());			
		}
		
		
	}//end of main
}
