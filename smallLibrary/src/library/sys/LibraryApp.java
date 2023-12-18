package library.sys;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
	public static void main(String[] args) {
		boolean run = true;

		Scanner scn = new Scanner(System.in);
		MemberDAO memDAO = new MemberDAO();
		BookDAO bookDAO = new BookDAO();
		
		System.out.println("작은도서관에 오신 것을 환영합니다."); // 처음에 딱 한번만 뜨게 하는건 어떻게?
		while (run) {
			System.out.println("1.도서 리뷰 2.관리자");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:// 1.도서리뷰

				break;
			case 2:// 2.관리자
				System.out.println("관리자 아이디를 입력하세요>>");
				String id = scn.nextLine();
				System.out.println("관리자 패스워드를 입력하세요>>");
				String pw = scn.nextLine();

				if (id.equals("a") && pw.equals("a")) {
					System.out.println("관리자 로그인 성공");
				} else {
					System.out.println("관리자 정보가 맞지 않습니다.");
					break;
				}

				System.out.println("1)회원관리 2)장서관리 3)게시판관리 #)종료");
				menu = Integer.parseInt(scn.nextLine());
				switch (menu) { // 2.관리자 switch
				case 1:// 2.1) 회원관리
					System.out.println("(1)회원등록 (2)회원목록 (3)회원정보조회 (4)회원대출내역 (5)회원수정 (6)회원삭제 (#)나가기");
					menu = Integer.parseInt(scn.nextLine());

					switch (menu) {// 2. 1)
					case 1:// 2. 1) (1)회원등록
						System.out.println("아이디>> ");
						String memId = scn.nextLine();
						System.out.println("이름>>");
						String memName = scn.nextLine();
						System.out.println("전화번호>>");
						String memPhone = scn.nextLine();

						Member mem = new Member(memId, memName, memPhone);

						if (memDAO.addMember(mem)) {
							System.out.println("저장되었습니다");
						} else {
							System.out.println("저장 실패");
						}
						break;
					case 2:// 2. 1) (2)회원목록
						ArrayList<Member> member2 = memDAO.getMemberList();
						System.out.println("==========================================");
						System.out.println("아이디    이름    전화번호");
						System.out.println("------------------------------------------");
						for(Member mems : member2) {
							mems.showInfo();
						}
						System.out.println("==============================================");
						break;
					case 3:// 2. 1) (3)회원정보조회						
						System.out.println("이름을 입력하세요>>");
						String name = scn.nextLine();
						ArrayList<Member> member3 = memDAO.getMember(name);
						System.out.println("==============================================");
						System.out.println("아이디    이름    전화번호   대출중도서   연체여부   회원등급");
						System.out.println("----------------------------------------------");
						for(Member mems : member3) {							
								mems.showMems();
							}
						
						System.out.println("==============================================");

						break;
					case 4:// 2. 1) (4)회원도서내역
						//멘붕...다시하기
						
						System.out.println("아이디를 입력하세요>>");
						id = scn.nextLine();
						Member memberName = memDAO.getMemberName(id);						
						
						if(memberName != null) {
							memberName.showName();
							System.out.println("==============================================");
							System.out.println("아이디    이름    전화번호   대출중도서   연체여부   회원등급");
							System.out.println("----------------------------------------------");
							ArrayList<BookHistory> bookHistory = new ArrayList<>();
							for(BookHistory hst : bookHistory) {
								if(hst != null) {
									hst.showHst();								}
							}
							System.out.println("==============================================");
						}else {
							System.out.println("일치하는 회원이 없습니다.");
						}					
						
						break;
					case 5:// 2. 1) (5)회원수정
						System.out.println("아이디를 입력하세요>> ");
						id = scn.nextLine();
						System.out.println("전화번호를 입력하세요>> ");
						String phone = scn.nextLine();
						
						if(memDAO.modifyMember(id, phone)) {
							System.out.println("수정 완료");
						}else {
							System.out.println("수정 실패");
						}						
						break;
					case 6:// 2. 1) (6)회원삭제
						System.out.println("삭제할 회원 아이디 입력>>> ");
						id = scn.nextLine();
						if(memDAO.removeMember(id)) {
							System.out.println("삭제 완료");
						}else {
							System.out.println("삭제 실패");
						}
						
						break;
					default:// 2. 1) (8)나가기

					}

					break;
				case 2:// 2.2) 장서관리
					System.out.println("(1)도서검색 (2)대출 (3)반납 (4)장서목록 (#)나가기");
					menu = Integer.parseInt(scn.nextLine());
					switch (menu) {
					case 1: //(1)도서검색
						System.out.println("도서명을 입력하세요>>");
						String title = scn.nextLine();
						boolean exists = false;
						
						ArrayList<Book> books = bookDAO.getBook(title);
						System.out.println("==============================================");
						System.out.println("도서코드	도서명	저자	출판사	대출여부");
						System.out.println("----------------------------------------------");
						
						for(Book book : books) {							
								book.showBook();
								exists = true;
							}

						if(!exists) {
							System.out.println("일치하는 도서가 없습니다.");
						}						
						System.out.println("==============================================");

						break;
					case 2: //(2)대출
						System.out.println("아이디>> ");
						id = scn.nextLine();
						System.out.println("도서코드>> ");
						String code = scn.nextLine();
						System.out.println("날짜>> ");
						String date = scn.nextLine();
						
						if(bookDAO.modifyIn(id, code, date)) {
							System.out.println("대출 완료");
						}else {
							System.out.println("대출 실패");
						}										
						break;
					case 3: //(3)반납
						System.out.println("아이디>> ");
						id = scn.nextLine();
						System.out.println("도서코드>> ");
						code = scn.nextLine();
						System.out.println("날짜>> ");
						date = scn.nextLine();
						
						if(bookDAO.modifyOut(id, code, date)) {
							System.out.println("반납 완료");
						}else {
							System.out.println("반납 실패");
						}
						break;
					case 4: //(4)도서 등록
						
						break;
					case 5: //(5)도서 삭제 
						break;
					case 6: //(#)나가기
						break;
					}// end of 2.2) 장서관리 의 switch문

					break;
				case 3:// 2.3) 게시판관리
					break;
				case 4:// 2.4) 종료
					break;
				}// end of 2.관리자 switch

			}// end of while

		} // end of 가장 바깥쪽 switch
	}// end of main

}// end of class
