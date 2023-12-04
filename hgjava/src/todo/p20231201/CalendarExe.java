package todo.p20231201;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		int year = 2023;
		int month = 12;

		Calendar today = Calendar.getInstance();

		// 10월 달력 작성하기
		today.set(Calendar.YEAR, year);
		today.set(Calendar.MONTH, (month - 1));
		today.set(Calendar.DATE, 1);

		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();

		
			
		
				
		for (int i = 0; i< today.get(Calendar.DAY_OF_WEEK) -1 ; i++ ) {
			System.out.printf("%4s", " ");
		}		
		for (int i=1; i <= today.getActualMaximum(Calendar.DATE) ; i++) {
			System.out.printf("%4d", i);
			if ((i+today.get(Calendar.DAY_OF_WEEK)-1 ) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n===============");
		
		
		
//		내가 한거...망한듯?
//		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };		
//				for (String day : days) {
//					System.out.printf("%4s", day);
//				}
//				System.out.println();
//		
//		for (int i = 0; i<= today.get(Calendar.DAY_OF_WEEK)  ; i++ ) {
//			System.out.printf("%4s", " ");
//		}		
//		for (int j = today.get(Calendar.DAY_OF_WEEK)+1 ; j <= today.get(Calendar.DAY_OF_WEEK)+ today.getActualMaximum(Calendar.DATE) ; j++) {
//			System.out.printf("%4d", j-today.get(Calendar.DAY_OF_WEEK));
//			if ( (j+1) % 7 == 0) {
//				System.out.println();
//			}
//		}

		// 12월 달력 작성하기
//		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
//
//		for (String day : days) {
//			System.out.printf("%4s", day);
//		}
//		System.out.println();

//		// 빈공백 생성
//		for (int i = 0; i < 5; i++) {
//			System.out.printf("%4s", " ");
//		}
//
//		for (int i = 1; i <= 31; i++) {
//			System.out.printf("%4d", i);
//			if (i % 7 == 0) {
//				System.out.println();
//			}
//		}
//		System.out.println("\n== the end ==");

//		int monthDay = 5; //월의 시작하는 요일의 인덱스를 삽입하면 됨!
//		int lastday = 31;
//				
//		for (int i = 0; i< monthDay ; i++ ) {
//			System.out.printf("%4s", " ");
//		}		
//		for (int j = monthDay ; j < monthDay+31 ; j++) {
//			System.out.printf("%4d", j-monthDay + 1);
//			if ((j+1) % 7 == 0) {
//				System.out.println();
//			}
//		}
	}
}
