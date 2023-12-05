package remind7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import remind6.Student;

public class StudentApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		List<Student> students = new ArrayList<>(); //StudentExe에 선언했는데 여기서 이거 안 쓰면 왜 오류날까?????
		StudentExe exe = new StudentExe();
		
		boolean run = true;
		while(run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			
			switch(menu) {
			case 1://등록
				System.out.println("학생번호입력>> ");
				String studentNumber = scn.nextLine();
				System.out.println("학생이름입력>> ");
				String studentName = scn.nextLine();
				System.out.println("영어점수입력>> ");
				int englishScore = Integer.parseInt(scn.nextLine());
				System.out.println("수학점수입력>> ");
				int mathmaticScore = Integer.parseInt(scn.nextLine());
				
				students.add(new Student(studentNumber, studentName, englishScore, mathmaticScore));
				System.out.println("저장되었습니다");				
				break;
			case 2://목록보기
				for(Student stu:students) {
					System.out.println(stu);
				}				
				break;
//			case 3://단건조회
//				System.out.println("조회할 학생번호 입력>>>>");
//				studentNumber = scn.nextLine();
//				for(int i= 0; i <students.size(); i++) {
//					if(students.get(i).getStudentNumber().equals(studentNumber)) {
//						
//					}
//				}
//				break;
//			case 4://번호입력후 영어, 수학 수정
//				System.out.println("수정할 학생번호 입력>>>>");
//				studentNumber = scn.nextLine();
//				for(int i= 0; i <students.size(); i++) {
//					if(students.get(i).getStudentNumber().equals(studentNumber)) {
//						
//					}
//				}
//				break;
			case 5://이름 입력 후 삭제(null)로 바꿈
				break;
			case 6:
				break;
			}
		}
		
		
	}//end of main
	
	
}
