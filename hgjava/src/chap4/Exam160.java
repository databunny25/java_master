package chap4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		// ����2 : 3�� ��� ��
		
		int i = 0;
		int sumthree = 0;
		
		for (i = 1; i <= 100 ; i ++) {
			if(i % 3 == 0) {
				sumthree += i;
			}else {
				continue;
			}
			
		}
		
		System.out.println("3�� ����� ����: " + sumthree);
		
		
		//���� 3 
		
		
		while(true) {
			int dice1 = (int)(Math.random() * 6 ) + 1;
			int dice2 = (int)(Math.random() * 6 ) + 1;
			System.out.printf("(%d,%d)\n", dice1, dice2);
			if(dice1 + dice2 == 5) {
				break;
			}
		}
		System.out.println("����");
		
		
		//���� 4
		
		//x : 1~10���� �ݺ�
			// y 1~10���� �ݺ�
				//4*x + 5*y = 60�� �� ã��
		
		int x = 1;
		int y = 1;	
		
		for(x = 1 ; x <= 10 ; x ++) {
			for(y = 1 ; y <= 10 ; y ++) {
				if(4 * x + 5 * y == 60) {
					System.out.printf("(%d,%d)\n", x, y);
				}
			}
		}
		
		//���� 5
		
		for( int s = 1 ; s <=4 ; s++) {
			for( int j = 1 ; j <= s ; j ++) {
				System.out.println("*");
			}
			System.out.println("\n");
		}
		
		
		//���� 6
		
		//���� 7
		
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		
		while(run) {
			System.out.println("----------------------------------");
			System.out.println("1. ���� | 2. ��� | 3. �ܰ� | 4. ����");
			System.out.println("----------------------------------");
			System.out.print("����> ");
			String num = sc.nextLine();
			
			switch(num) {
			case "1" : 
				System.out.print("���ݾ�>");
				balance += Integer.parseInt(sc.nextLine());		
				break;
			case "2" : 
				System.out.print("��ݾ�>");
				int money = Integer.parseInt(sc.nextLine());
				if( money <= balance) {
				balance -= money;		
				
				}else {
					System.out.println("�ܾ��� �����մϴ�");
					
				}
				break;
			case "3" : 
				System.out.print("�ܰ�>");
				System.out.println("�ܾ��� "+ balance + "�� �Դϴ�");
				break;
			default : 
				run = false;
			}
			
			
		}
		
		System.out.println("���α׷� ����");
		
		
		
		
//		�ؼ�
//		boolean run = true;
//		int balance = 0;
//		Scanner sc = new Scanner(System.in);
//		int money = 0;
//		
//		
//		while(run) {
//			System.out.println("----------------------------------");
//			System.out.println("1. ���� | 2. ��� | 3. �ܰ� | 4. ����");
//			System.out.println("----------------------------------");
//			System.out.print("����> ");
//			int sNum = sc.nextInt();
//			
//			switch(sNum) {
//			case 1 :
//				System.out.println("���ݾ� > ");
//				money = sc.nextInt();
//				balance += money;
//				break;
//			case 2 :
//				System.out.println("��ݾ� > ");
//				money = sc.nextInt();
//				if(money > balance) {
//					System.out.println("�ܰ����");
//				}else {
//					balance += money;					
//				}
//				break;
//			case 3 :
//				System.out.println("�ܰ� > " + balance);
//				break;
//			case 4 :
//				System.out.println("���α׷� ����");
//				run = false;
//			}
//		
		
		
		
	} //end main

}//end class
