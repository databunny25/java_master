package chap11.object;

public class MathExe {
	public static void main(String[] args) {
		long result = (long) Math.round(-1.5); // double타입으로 리턴하므로 long으로 바꿔줌
		System.out.println("round: " + result);

		long results = (long) Math.rint(-1.5);
		System.out.println("rint: " + results);
		
		// 61~100점
		for (int i = 1; i <= 10; i++) {
			int r = 61 + (int) (Math.random() * 40); // 0 <= x <10
			System.out.println(r);
		}
		
		// 1~6 수
		int[] numbers = new int[5];
		// 중복되지 않은 값을 배열에 저장
		//1. 1~6 숫자생성
		//2 생성된 값이 배열이 있는지 체크
		//3 없으면 추가
		//4 배열에 값이 다 저장되면 종료
		for ( int i = 0; i <numbers.length; i++) {
			boolean exist = false;
			int no = 1 + (int) (Math.random()*6);
			//체크
			for(int j=0; j<1; j++) {
				if(numbers[j] == no)
					exist = true;
			}
			//있으면 저장 안하고...
			if(exist) {
				i--;
				continue;
			}
			//없으면 저장하고...
			numbers[i] = no;
			
			System.out.println(numbers[i]);
		}
		
		
		
		
		}//end of main
}//end of Class
