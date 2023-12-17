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
			case 1://1.도서리뷰
				
				
				break;
			case 2://2.관리자
				System.out.println("관리자 아이디를 입력하세요>>");
				String id = scn.nextLine();
				System.out.println("관리자 패스워드를 입력하세요>>");
				String pw = scn.nextLine();
				
				if(id == "manager" && pw == "libmanager") {
					System.out.println("관리자 로그인 성공");
				}else {
					System.out.println("관리자 정보가 맞지 않습니다.");
					break;
				}
				
				
				System.out.println("1)회원관리 2)장서관리 3)게시판관리 4)종료");
				menu = Integer.parseInt(scn.nextLine());
				switch(menu) { //2.관리자 switch
					case 1:// 2.1) 회원관리
						System.out.println("(1)회원등록 (2)회원목록 (3)회원정보조회 (4)회원대출내역 (5)회원수정 (6)회원삭제 (7)회원등급기준 (8)나가기");
						menu = Integer.parseInt(scn.nextLine());
						
						switch(menu) {// 2. 1)
						case 1:// 2. 1) (1)회원등록
							System.out.println("아이디>> ");
							System.out.println("이름>>");
							System.out.println("전화번호>>");
							
							break;
						case 2:// 2. 1) (2)회원목록
							System.out.println("==========================================");
							System.out.println("아이디      이름    전화번호");
							System.out.println("------------------------------------------");
							
							
							
							System.out.println("==============================================");
							break;
						case 3:// 2. 1) (3)회원정보조회
							System.out.println("이름을 입력하세요>>");
							
							
							System.out.println("==============================================");
							System.out.println("아이디    이름    전화번호   대출중도서   연체여부   회원등급");
							System.out.println("----------------------------------------------");
							
							
							
							System.out.println("==============================================");
							
							break;
						case 4:// 2. 1) (4)회원대출내역
							
							
							break;
						case 5:// 2. 1) (5)회원수정
							break;
						case 6:// 2. 1) (6)회원삭제
							break;
						case 7:// 2. 1) (7)회원등급기준
							break;
						default:// 2. 1) (8)나가기		
						
						}
						
						break;						
					case 2:// 2.2) 장서관리
						switch(menu) {
						case 1:
							System.out.println("도서명을 입력하세요>>");
							System.out.println("==============================================");
							System.out.println("도서코드	도서명					저자			대출여부");
							System.out.println("==============================================");
							System.out.println("==============================================");
							
							break;
						case 2:
							System.out.println("아이디>>");
							System.out.println("도서코드>>");
							
							
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
						}//end of 2.2) 장서관리 의 switch문
						
						
						
						break;
					case 3:// 2.3) 게시판관리
						break;
					case 4:// 2.4) 종료						
						break;
				}//end of 2.관리자 switch
				
				
			
			
			}//end of 가장 바깥쪽 switch
		}//end of while
		
		
	}//end of main
	
	
}//end of class
