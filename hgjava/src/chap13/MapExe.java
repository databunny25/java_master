package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe {

	public static void main(String[] args) {
		
		//키:값 쌍으로 구성
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//추가
		map.put("홍길동", 80);
		map.put("김길동", 85);
		map.put("장효은", 90);
		map.put("홍길동", 90); //동일한 홍길동 키로 저장...80은 없어지고 새로운 값 90으로 저장된다
		
		//
		Integer result = map.get("홍길동");
		
		//전체목록
		Set<String> set = map.keySet();
		for(String key: set) {
			System.out.println("key: " + key + ", value: " + map.get(key));
		}
		
	}//end of main
	
	
}// end of class
