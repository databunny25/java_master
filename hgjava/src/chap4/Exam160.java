package chap4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		// 문제2 : 3의 배수 합
		
		int i = 0;
		int sumthree = 0;
		
		for (i = 1; i <= 100 ; i ++) {
			if(i % 3 == 0) {
				sumthree += i;
			}else {
				continue;
			}
			
		}
		
		System.out.println("3의 배수의 총합: " + sumthree);
		
		
		//문제 3 
		
		
		while(true) {
			int dice1 = (int)(Math.random() * 6 ) + 1;
			int dice2 = (int)(Math.random() * 6 ) + 1;
			System.out.printf("(%d,%d)\n", dice1, dice2);
			if(dice1 + dice2 == 5) {
				break;
			}
		}
		System.out.println("종료");
		
		
		//문제 4
		
		//x : 1~10까지 반복
			// y 1~10까지 반복
				//4*x + 5*y = 60인 값 찾기
		
		int x = 1;
		int y = 1;	
		
		for(x = 1 ; x <= 10 ; x ++) {
			for(y = 1 ; y <= 10 ; y ++) {
				if(4 * x + 5 * y == 60) {
					System.out.printf("(%d,%d)\n", x, y);
				}
			}
		}
		
		//문제 5
		
		for( int s = 1 ; s <=4 ; s++) {
			for( int j = 1 ; j <= s ; j ++) {
				System.out.println("*");
			}
			System.out.println("\n");
		}
		
		
		//문제 6
		
		//문제 7
		
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		
		while(run) {
			System.out.println("----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------------------------");
			System.out.print("선택> ");
			String num = sc.nextLine();
			
			switch(num) {
			case "1" : 
				System.out.print("예금액>");
				balance += Integer.parseInt(sc.nextLine());		
				break;
			case "2" : 
				System.out.print("출금액>");
				int money = Integer.parseInt(sc.nextLine());
				if( money <= balance) {
				balance -= money;		
				
				}else {
					System.out.println("잔액이 부족합니다");
					
				}
				break;
			case "3" : 
				System.out.print("잔고>");
				System.out.println("잔액은 "+ balance + "원 입니다");
				break;
			default : 
				run = false;
			}
			
			
		}
		
		System.out.println("프로그램 종료");
		
		
		
		
//		해설
//		boolean run = true;
//		int balance = 0;
//		Scanner sc = new Scanner(System.in);
//		int money = 0;
//		
//		
//		while(run) {
//			System.out.println("----------------------------------");
//			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
//			System.out.println("----------------------------------");
//			System.out.print("선택> ");
//			int sNum = sc.nextInt();
//			
//			switch(sNum) {
//			case 1 :
//				System.out.println("예금액 > ");
//				money = sc.nextInt();
//				balance += money;
//				break;
//			case 2 :
//				System.out.println("출금액 > ");
//				money = sc.nextInt();
//				if(money > balance) {
//					System.out.println("잔고부족");
//				}else {
//					balance += money;					
//				}
//				break;
//			case 3 :
//				System.out.println("잔고 > " + balance);
//				break;
//			case 4 :
//				System.out.println("프로그램 종료");
//				run = false;
//			}
//		
		
		
		
	} //end main

}//end class
