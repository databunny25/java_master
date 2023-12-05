package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TypingSpeedGame {
	public static void main(String[] args) {
		// Scanner 사용해서 입력값
		Scanner scn = new Scanner(System.in);
		String word = "Programming is a kind of communication with a computer which can happen through various languages and methods";
		String[] words = word.split(" ");
		List<String> list = new ArrayList<>();

		for (String str : words) {
			list.add(str);
		}

		boolean run = true;

		long start = System.currentTimeMillis();
		while (run) {
			// 목록출력
			System.out.println(list);
			System.out.println(list.size());
//			for (String str : list) {
//				System.out.println(str);
//			}

			// 입력값과 목록값 비교해서 있으면 제거
			// 사용자 입력값과 컬렉션의 값과 비교해서 같은 단어 있으면 삭제
//			list.remove(0);
//			System.out.println(list.size());

			System.out.println("제거할 단어 입력>> ");
			String removeWord = scn.nextLine();
			boolean exist = false;

			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).equals(removeWord)) {
					list.remove(i);
					exist =true;
				}
			}
			if(!exist) {
				System.out.println("없는 단어");
			}

			if(list.size() == 0) {
				System.out.println("종료");
				//break;
				run = false;
			}
			
		} // end of while
		long end = System.currentTimeMillis();
		System.out.println("완료시간 : " + (end - start)/1000 );		
		System.out.println("end of game");

		// 시작시점~종료시점 걸린시간을 초단위로 계산
		// 완료하는데 35초가 걸림

	}// end of main
}// end of class
