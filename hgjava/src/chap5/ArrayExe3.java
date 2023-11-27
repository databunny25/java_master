package chap5;

public class ArrayExe3 {

	public static void main(String[] args) {
		String[] nameAry = {"홍길동", "김길동", "박길동", "홍길동", "황길동"};
		
		String search = "홍길동";
		
		int count = 0;
		// for 반복문 활용
		for (String name : nameAry) {
			if (name.equals(search)) {
				count++;
			}
		}
		
		System.out.println(search + "은 총 " + count + "명 입니다.");

		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = 0;
		
		
		for(int num: scores) {
			if ( maxScore < num) {
				maxScore = num;
			}
		}
		
//		이것보다 위가 훨씬 쉽다~
//		for(int i = 0 ; i < scores.length ; i++) {
//			if (scores[i] > maxScore) {
//				maxScore = scores[i];
//			}
//		}
		
		System.out.println("최고점은 " + maxScore + "점 입니다");
		
		
	}

}
