package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		// 1~50 : 369����
		// 3, 6, 9 ���� üũ ����
		int cnt = 0;
		// ���� 1~50 �ݺ���
		for(int i=1; i<= 50; i++) {
			cnt = 0; //���� ���� ���� �ʱ�ȭ
			if(i%10 ==3 || i%10 == 6 || i%10 == 9) cnt++; //���� �ڸ��� 3,6,9 ���� üũ
			if(i/10 ==3 || i/10 == 6 || i/10 == 9) cnt++; //���� �ڸ��� 3,6,9 ���� üũ
			// ������ 0 -> ����, ������ 1 -> ��, ������ 2 -> ����
			switch(cnt) {
			case 0 : System.out.print(i + "\t");break;
			case 1 : System.out.print("��\t");break;
			case 2 : System.out.print("����\t");break;
			}
			if(i%10 == 0) System.out.println(); //�� �ٿ� 10���� ���			
		}				
//		���� �� Ʋ�� �� ��������
//		for(int i = 1; i <= 50 ; i ++) {
//			if((i % 10 == 3) || (i % 10 == 6) || (i % 10 == 9) ) {
//				System.out.print("�� ");
//			}else if((i / 10 == 3) || (i / 10 == 6) || (i / 10 == 9)) {
//				System.out.print(" ��");
//			}else {
//				System.out.print(" " + i);
//			}//			
//		}
//		
		//���� ��ȯ
		
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int rmoney = 0;
				
		
		System.out.print("##��ȯ�� �ݾ� : ");
		
		System.out.println("\n500�� ¥�� : " + money / 500);
		rmoney = money % 500;
		
		System.out.println("100�� ¥�� : " + rmoney / 100);
		rmoney %= 100;
		
		System.out.println("50�� ¥�� : " + rmoney / 50);
		rmoney %= 50;
		
		System.out.println("10�� ¥�� : " + rmoney / 10);
		rmoney %= 10;
		
		System.out.println("��ȯ �ݾ� : " + (money - rmoney) );
		System.out.println("���� �ݾ� : " + rmoney );
		
		
		
		
		
		
		
		
		
		// ���� ���߱� 1~100 ���̼�
		
		// com ���� �߻� Math.random()
		
		// �ݺ��� ����
			//���� �Է� ����
			// �Է¼��� == com -> �����մϴ� �ݺ��� Ż��
			// �Է¼��� == com -> down �ϼ���
			// �Է¼��� == com -> up �ϼ���
		
		
		
		//����� �غ���
		for(int i=0; i<10; i++) {
			System.out.println("hhhh");
			}
		
		
		
		
		
		

	}//end main

}//end class
