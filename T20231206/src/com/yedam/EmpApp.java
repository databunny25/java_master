package com.yedam;

import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		boolean run = true;

		Scanner scn = new Scanner(System.in);
		EmpDAO empDAO = new EmpDAO();

		while (run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:// 등록
				System.out.println("사번입력");
				String code = scn.nextLine();
				System.out.println("이름입력");
				String name = scn.nextLine();
				System.out.println("전화번호입력");
				String phone = scn.nextLine();
				System.out.println("입사일입력");
				String date = scn.nextLine();
				System.out.println("급여입력");
				int salary = Integer.parseInt(scn.nextLine());

				Employee employee = new Employee(code, name, phone, date, salary);

				if (empDAO.addEmp(employee)) {
					System.out.println("저장되었습니다.");
				} else {
					System.out.println("등록 실패");
				}
				break;
			case 2:// 목록
				System.out.println("사번\t이름\t전화번호");
				boolean exist = false;
				for (Employee employeeInfo : empDAO.getEmployeeList()) {
					if (employeeInfo != null) {
						employeeInfo.showInfo();
						exist = true;
					} 
				}
				if(!exist) {
					System.out.println("사원이 없습니다.");
				}
				
				break;
			case 3:// 수정(급여)
				System.out.println("사번입력>>");
				code = scn.nextLine();
				System.out.println("급여입력>>");
				salary = Integer.parseInt(scn.nextLine());

				if (empDAO.modifyEmployee(code, salary)) {
					System.out.println("수정되었습니다");
				} else {
					System.out.println("수정 실패");
				}
				break;
			case 4:// 삭제
				System.out.println("사번입력>>");
				code = scn.nextLine();

				if (empDAO.removeEmployee(code)) {
					System.out.println("삭제되었습니다");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 5:// 조회(입사일자)
				System.out.println("입사일자>> ");
				date = scn.nextLine();
				System.out.println("사번\t이름\t입사일자");
				exist = false;
				for(Employee emp: empDAO.getDateList(date)) {
					if(emp != null) {
						emp.showDateInfo();
					}
				}
				if(!exist) {
					System.out.println("사원이 없습니다.");
				}
				break;
			case 6:// 종료
				System.out.println("프로그램을 종료합니다");
				run = false;
			}// end of switch
		} // end of while
	}// end of main

}
