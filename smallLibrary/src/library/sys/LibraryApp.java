package library.sys;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
	public static void main(String[] args) {
		boolean run = true;

		Scanner scn = new Scanner(System.in);
		MemberDAO memDAO = new MemberDAO();
		BookDAO bookDAO = new BookDAO();

		System.out.println("*****************************");
		System.out.println("	🕮 작은 도서관 "); // 처음에 딱 한번만 뜨게 하는건 어떻게?
		System.out.println("*****************************");

		while (run) {

			System.out.println("-관리자 아이디를 입력하세요>>");
			String id = scn.nextLine();
			System.out.println("-관리자 패스워드를 입력하세요>>");
			String pw = scn.nextLine();

			if (id.equals("admin") && pw.equals("yedam")) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("아이디나 비밀번호를 바르게 입력해주세요");
				continue;
			}

			
			boolean run2 = true;
			while (run2) {
				System.out.println("1.회원관리 2.장서관리 3.종료");
				int menu = Integer.parseInt(scn.nextLine());


				switch (menu) { // 관리자 switch
				case 1:// 1. 회원관리
					boolean run3 = true;
					while(run3) {
						
					
					
					System.out.println("1)회원등록 2)회원조회 3)회원대출내역 4)회원수정 5)회원삭제 6)나가기 ");
					menu = Integer.parseInt(scn.nextLine());

					switch (menu) {// 2. 1)
					case 1:// 1. (1)회원등록
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
					
					case 2:// 1. (2)회원조회
						//연체여부, 회원등급 해결...
						System.out.println("아이디를 입력하세요>>");
						id = scn.nextLine();
						
						Member mem2 = memDAO.getMember(id);
						System.out.println("===============================================");
						System.out.println("아이디    이름    전화번호  	 	총대출횟수	회원등급");
						System.out.println("-----------------------------------------------");
						
						if(mem2 != null) {
							mem2.showMems();
						}else {
							System.out.println("존재하지 않는 회원입니다.");
						}

						System.out.println("=====================================================");

						break;
					case 3:// 1. (3)회원대출내역  
					
						System.out.println("아이디를 입력하세요>>");
						id = scn.nextLine();
						boolean exists = false;

						ArrayList<BookHistory> historys = memDAO.getMemHistory(id);
						System.out.println("==========================================");
						System.out.println("	날짜		도서코드	도서명");
						System.out.println("------------------------------------------");

						for (BookHistory bhst : historys) {
							if (bhst != null) {
								bhst.showHst();
								exists = true;
							}
						}
						if (!exists) {
							System.out.println("도서 대출 내역이 없습니다.");
						}
						System.out.println("==========================================");

						break;
						
						
						
					case 4:// 1.(4)회원수정
						System.out.println("아이디를 입력하세요>> ");
						id = scn.nextLine();
						System.out.println("전화번호를 입력하세요>> ");
						String phone = scn.nextLine();

						if (memDAO.modifyMember(id, phone)) {
							System.out.println("수정 완료");
						} else {
							System.out.println("수정 실패");
						}
						break;
					case 5:// 1. (5)회원삭제
						System.out.println("삭제할 회원 아이디 입력>>> ");
						id = scn.nextLine();
						if (memDAO.removeMember(id)) {
							System.out.println("삭제 완료");
						} else {
							System.out.println("삭제 실패");
						}

						break;
					case 6: // 1. (6)나가기
						System.out.println("이전 메뉴로 돌아갑니다");
						run3=false;
						break;
					default:
						System.out.println("올바른 번호를 입력하세요");
						continue;
					}

					}//end of while run3
					break;
				case 2:// 2. 장서관리
					boolean run4= true;
					while(run4) {
						
					
					
					System.out.println("(1)도서검색 (2)대출 (3)반납 (4)장서목록 (5)나가기");
					menu = Integer.parseInt(scn.nextLine());
					switch (menu) {
					case 1: // 2. (1)도서 검색 (입력한 이름과 일치하는 도서 전부 보여주기)
						System.out.println("도서명을 입력하세요>>");
						String title = scn.nextLine();
						boolean exists = false;

						ArrayList<Book> books = bookDAO.getBook(title);
						System.out.println("==============================================");
						System.out.println("도서코드	도서명		저자	출판사	대출여부");
						System.out.println("----------------------------------------------");

						for (Book book : books) {
							if (book != null) {
								book.showBook();
								exists = true;
							}
						}

						if (!exists) {
							System.out.println("일치하는 도서가 없습니다.");
						}
						System.out.println("==============================================");

						break;
					case 2: // 2. (2)대출
						System.out.println("아이디>> ");
						id = scn.nextLine();
						System.out.println("도서코드>> ");
						String code = scn.nextLine();
						System.out.println("날짜>> ");
						String date = scn.nextLine();

						if (bookDAO.modifyIn(id, code, date)) {
							System.out.println("대출 완료");
						} else {
							System.out.println("대출 실패");
						}
						break;
					case 3: // 2. (3)반납
						System.out.println("아이디>> ");
						id = scn.nextLine();
						System.out.println("도서코드>> ");
						code = scn.nextLine();
						System.out.println("날짜>> ");
						date = scn.nextLine();

						if (bookDAO.modifyOut(id, code, date)) {
							System.out.println("반납 완료");
						} else {
							System.out.println("반납 실패");
						}
						break;
					case 4:// 2. (4) 장서목록
						ArrayList<Book> bookList = bookDAO.getBookList();
						System.out.println("==============================================");
						System.out.println("도서코드	도서명			저자		출판사	대출여부");
						System.out.println("----------------------------------------------");
						for (Book book : bookList) {
							book.showBook();
						}
						System.out.println("==============================================");
						break;
					case 5: // 2. (5) 나가기
						System.out.println("이전 메뉴로 돌아갑니다");
//						run2=false;
						run4=false;
						break;
//					case 6: // (6)도서 등록
//						
//						break;
//					case 7: // (7)도서 삭제
//						break;
					default:
						System.out.println("올바른 번호를 입력하세요");
						continue;
					}// end of 2) 장서관리 의 switch문
					}//end of while run4
					break;

				case 3:// 3.종료
					System.out.println("프로그램을 종료합니다");
					run = false;
					run2 = false;
					break;
				default:
					System.out.println("올바른 번호를 입력하세요");
					continue;
				} //end of switch
				
			} //end of while(run2)
		} // end of while(run)

	}// end of main
	
	
	
	
}// end of class
