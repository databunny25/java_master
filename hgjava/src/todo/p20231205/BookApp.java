package todo.p20231205;

import java.util.ArrayList;
import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {
		boolean run = true;

		Scanner scn = new Scanner(System.in);
		BookExe exe = new BookExe();
//		List<Book> books = new ArrayList<>();

		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.종료");
			System.out.println("============================");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.println("도서코드입력>>> ");
				String code = scn.nextLine();
				System.out.println("도서명입력>>> ");
				String title = scn.nextLine();
				System.out.println("저자입력>>> ");
				String inputAuthor = scn.nextLine();
				System.out.println("출판사입력>>> ");
				String inputPublisher = scn.nextLine();
				System.out.println("가격입력>>> ");
				int inputPrice = Integer.parseInt(scn.nextLine());

				Book bookbook = new Book(code,title,inputAuthor,inputPublisher, inputPrice);
				
				if(exe.addBook(bookbook)) {
					System.out.println("저장되었습니다.");
				}else {
					System.out.println("실패했습니다.");
				}
				
				break;
			case 2:
//				ArrayList<Book> bookAry = exe.getBookList();
//				for (Book bookInfo : bookAry) {
				System.out.println("도서코드 도서 저자 가격");
				for (Book bookInfo : exe.getBookList()) {
					if (bookInfo != null) {
						bookInfo.showInfo();
					} else {
						System.out.println("목록이 없습니다");
					}
				}
				break;
			case 3:
				System.out.println("도서코드입력>> ");
				code = scn.nextLine();
				System.out.println("가격입력>>");
				inputPrice = Integer.parseInt(scn.nextLine());

				if (exe.modifyPrice(code, inputPrice)) {
					System.out.println("수정되었습니다.");
				} else {
					System.out.println("수정실패");
				}
				break;
			case 4:
				System.out.println("도서코드입력>> ");
				code = scn.nextLine();

				if (exe.removeBook(code)) {
					System.out.println("삭제되었습니다");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다");
				run = false;
			}

		}
	}// end of main

}
