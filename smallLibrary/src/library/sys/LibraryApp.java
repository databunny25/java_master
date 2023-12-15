package library.sys;

import java.util.Scanner;

public class LibraryApp {
	public static void main(String[] args) {
		boolean run = true;
		
		Scanner scn = new Scanner(System.in);
		
		
		System.out.println("작은도서관에 오신 것을 환영합니다"); //처음에 딱 한번만 뜨게 하는건 어떻게?
		while(run) {
			System.out.println("1.도서 리뷰 2.관리자");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:
				
			case 2:
				System.out.println("관리자 아이디를 입력하세요>>");
				String id = scn.nextLine();
				System.out.println("관리자 패스워드를 입력하세요>>");
				String pw = scn.nextLine();
				
//				if(id = "manager" && pw = "libmanager") {
//					System.out.println("관리자 로그인 성공");
//				}else {
//					System.out.println("관리자 정보가 맞지 않습니다.");
//				}
			
			
			}//end of 가장 바깥쪽 switch
		}//end of while
		
		
	}//end of main
	
	
}//end of class
