package chap10;

public class ArrayExceptionExe {
	public static void main(String[] args) {

		// 배열의 범위를 벗어난 위치의 값 참조하려고 하는 경우의 예
		int[] numAry = { 2, 5, 7 };
		try {
			for (int i = 0; i <= 3; i++) {
				System.out.println(numAry[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("범위의 값을 벗어남.");
		}
		System.out.println("end of prog.");
		}

	}

