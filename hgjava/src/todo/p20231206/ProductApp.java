package todo.p20231206;

import java.util.Scanner;

public class ProductApp {
	public static void main(String[] args) {
		boolean run = true;

		Scanner scn = new Scanner(System.in);
		ProductExe productExe = new ProductExe();
		InOutExe inOutExe = new InOutExe();

		while (run) {
			System.out.println("1.상품관리 2.입출고관리 3.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:// 1.상품관리
				System.out.println("1-1)등록 1-2)수정 1-3)목록");
				menu = Integer.parseInt(scn.nextLine());

				switch (menu) {
				case 1: // 1)등록
					System.out.println("상품코드입력>>> ");
					String code = scn.nextLine();
					System.out.println("상품명>>> ");
					String name = scn.nextLine();
					System.out.println("가격입력>>> ");
					int price = Integer.parseInt(scn.nextLine());

					Product product = new Product(code, name, price);

					if (productExe.addProduct(product)) {
						System.out.println("저장되었습니다");
					} else {
						System.out.println("실패했습니다");
					}
					break;
				case 2: // 2)수정
					System.out.println("상품코드입력>>");
					code = scn.nextLine();
					System.out.println("가격입력>>");
					price = Integer.parseInt(scn.nextLine());

					if (productExe.modifyProduct(code, price)) {
						System.out.println("수정되었습니다");
					} else {
						System.out.println("수정실패");
					}
					break;
				case 3: // 3)목록
					System.out.println("상품코드/상품명/가격");
					System.out.println("==================");
					for (Product productInfo : productExe.getProductList()) {
						if (productInfo != null) {
							productInfo.showInfo();
						} else {
							System.out.println("상품이 없습니다");
						}
					}
					break;
				}// end of switch 1.상품관리
				break;
			case 2:// 2.입출고관리
				System.out.println("2-1)등록 2-2)수정 2-3)목록");
				menu = Integer.parseInt(scn.nextLine());

				switch (menu) {
				case 1: // 1)판매
					System.out.println("판매상품코드입력>>> ");
					String code = scn.nextLine();
					System.out.println("판매날짜입력>>> ");
					String date = scn.nextLine();
					System.out.println("판매수량입력>>> ");
					int num = Integer.parseInt(scn.nextLine());

					InOut inOut = new InOut(code, date, num, "판매");

					if (inOutExe.addInOut(inOut)) {
						System.out.println("저장되었습니다");
					} else {
						System.out.println("실패했습니다");
					}
					break;
				case 2: // 2)구매
					System.out.println("구매상품코드입력>>> ");
					code = scn.nextLine();
					System.out.println("구매날짜입력>>> ");
					date = scn.nextLine();
					System.out.println("구매수량입력>>> ");
					num = Integer.parseInt(scn.nextLine());

					inOut = new InOut(code, date, num, "구매");

					if (inOutExe.subtractInOut(inOut)) {
						System.out.println("저장되었습니다");
					} else {
						System.out.println("실패했습니다");
					}
					break;
				case 3: // 3)재고목록
					System.out.println("상품코드/처리날짜/수량/판(구)매");
					System.out.println("==========================");
//					for(InOut inOutInfo : inOutExe.getInOutList()) {
//						if(inOutInfo != null) {
//							inOutInfo.showInfo();
//						}else {
//							System.out.println("재고가 없습니다");
//						}
//					}
					inOutExe.getInOutList();
					break;
				}// end of switch 2.입출고관리
				break;
			case 3:// 종료
				System.out.println("프로그램을 종료합니다");
				run = false;
			}

		} // end of while바깥쪽
		System.out.println("end of prog.");

	}// end of main
}
