package Chap6;
	//1. 등록 2. 목록 3. 상세조회 4. 종료

import java.util.Scanner;

public class BoardApp {

	public static void main(String[] args) {
		boolean run = true;

		Scanner scn = new Scanner(System.in);
		
		while(run) {
			System.out.println("1.등록 2.목록 3.상세조회 4. 종료");
			int menu = Integer.parseInt(scn.nextLine());
			//게시글번호/제목/작성자/내용/작성일시
			switch(menu) {
			case 1:
				System.out.println("게시글번호 입력>>");
				int no = Integer.parseInt(scn.nextLine());
				System.out.println("제목 입력>>");
				String title = scn.nextLine();
				System.out.println("작성자 입력>>");
				String user = scn.nextLine();
				System.out.println("내용 입력>>");
				String contents = scn.nextLine();
				System.out.println("작성일시 입력>>");
				String date = scn.nextLine();
				
				Board boa = new Board(no, title, user, contents, date);
				//여기서부터 다시
			}
		}
		
	}//end of main

} //end of class
