package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExe3 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		
//		회원등록(회원번호, 이름, 포인트)
//		1.등록 2.이름조회 3.포인트변경(회원번호로 조회해서 포인트 넣어주면 그렇게 바뀜) 4.삭제(회원번호로 조회해서 단건삭제) 5.종료
		
		List<Member> members = new ArrayList<>();
		
//		교수님꺼
		System.out.println("회원번호 이름 포인트");
		
		String input = scn.nextLine();
		String[] inAry = input.split(" ");
		System.out.println(inAry[0]);
		System.out.println(inAry[1]);
		System.out.println(inAry[2]);
		
		members.add(new Member(inAry[0], inAry[1], Integer.parseInt(inAry[2])));
				
		System.out.println("end");
//		
		
		
		boolean run = true;		
		while(run) {
			System.out.println("1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:
				System.out.println("회원번호>> ");
				String memberNo = scn.nextLine();
				System.out.println("이름 입력>> ");
				String memberName = scn.nextLine();
				System.out.println("포인트 입력>> ");
				int point = Integer.parseInt(scn.nextLine());
				
				members.add(new Member(memberNo, memberName, point));
				System.out.println("저장되었습니다");
				break;
			case 2:
				System.out.println("조회할 이름 입력>> ");
				String findName = scn.nextLine();
				boolean exist = false;
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getMemberName().indexOf(findName) != -1) { 
						System.out.println(members.get(i)); 
						exist = true;
					}
				}
				if(!exist){
					System.out.println("찾는 이름이 없습니다.");
				}
				break;
			case 3:
				System.out.println("포인트 수정할 회원번호 입력>> ");
				
				
				String pointNum = scn.nextLine();
				int changePoint = 0;
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberNo().equals(pointNum)) {
						System.out.println("변경할 포인트 입력>>");
						changePoint = Integer.parseInt(scn.nextLine());
						members.get(i).setPoint(changePoint);
					}
				}
				break;
			case 4:
				System.out.println("삭제할 회원 번호 입력>> ");
								
				String delNum = scn.nextLine();
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberNo().equals(delNum)) {
						members.remove(i);
					}
				}
				break;
			case 5:
				System.out.println("end of prog");
				run = false;
			
			}
			
		}
		
		
		
		
	}//end of main
}