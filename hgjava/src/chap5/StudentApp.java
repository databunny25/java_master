package chap5;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int studentNum = 0;
		int[] scores = null;
		String[] names = null;
		
		int maxScore = 0;	
		double avg = 0;
		int sum = 0;
		String maxName = null;
		
		
		// 1. 학생수 2. 점수입력 3. 목록출력 4. 분석(최고점수, 평균) 5. 종료
		boolean run = true;
		while(run) {
			System.out.println("1. 학생수 2. 점수입력 3. 목록출력 4. 분석(최고점수, 평균) 5. 종료");
			int menu = scn.nextInt(); // Enter 전까지 처리하고 넘어가버리니까
			scn.nextLine(); //추가해서 Enter 처리해줌 (?????????)
			
			
			switch(menu) {
			
			case 1:
				System.out.println("학생수입력>>");
				studentNum = scn.nextInt();
				scores = new int[studentNum];
				names = new String[studentNum];
				break;
			case 2:
				System.out.println("점수입력>>");
				//for 반복문
				for(int i=0; i < scores.length; i++) {
					System.out.println("names[" + i + "]>>");
					names[i] = scn.nextLine();
					System.out.print("scores[" + i + "]>>");
					scores[i] = scn.nextInt();
					scn.nextLine();
				}
				break;
			case 3:
				System.out.println("목록출력>>");
				for(int i=0; i < scores.length; i++) {
					System.out.println("이름은 " + names[i] + ", 점수는 " + scores[i]);
					
				}
				break;
			case 4:
				System.out.println("분석>>");
				//for(int num : scores) {
				for(int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if(maxScore < scores[i]) {
						maxScore = scores[i];
						maxName = names[i];
					}			
					
				}
				avg = sum * 1.0 / scores.length; //sum과 scores.length 둘 다 int이므로 하나라도 실수로 바꿔주기 위해 *1.0을 해준다!!!
				
				
				
				System.out.println("최고점수 : " + maxName+ "의 " + maxScore + ", 평균 : " + avg);
				break;
			case 5:
				System.out.println("종료>>");
				run = false;
				break;
			} // end of switch.
		} // end of while.
		System.out.println("end of prog.");
	}

}
