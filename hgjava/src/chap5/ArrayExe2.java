package chap5;

public class ArrayExe2 {

	public static void main(String[] args) {
		// 정수를 담을 수 있는 배열을 생성(크기는 10개의 정수를 저장).
		// intAry => 10~100 저장.
		

		int[] intAry = new int[10];
		
		for (int i = 0 ; i < intAry.length ; i++) {			
			intAry[i] = (i + 1) * 10;
		}
		
		
		// 출력. 확장 for구문
		int sum = 0; // 50보다 큰 수를 저장
		double avg = 0;
		int count = 0;
		for (int num : intAry ) {
			System.out.println(num);
			if (num > 50) { //50보다 큰수를 sum에 누적합.
				count ++;
				sum += num;
			}
		}
		avg = sum / count;
		System.out.println("50보다 큰 수의 합계: " + sum);
		System.out.println("50보다 큰 수의 평균: " + avg);
		
	
		
		
	}

}
