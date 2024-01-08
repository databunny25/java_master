package com.yedam.common;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;

public class MainExe { //서블릿 만들기 복잡하니까 테스트 하기 위함
	public static void main(String[] args) {
		
		ReplyService svc = new ReplyServiceImpl();
		List<HashMap<String, Object>> list = svc.chartData();
		Gson gson = new GsonBuilder().create();
		System.out.println(gson.toJson(list));
		System.out.println(list);
		
		
		
//		int total = 70;
//		PageDTO dto = new PageDTO(13, total);
//		
//		System.out.println(dto.toString());
		
		
//		ReplyService svc = new ReplyServiceImpl();
//		svc.replyListPaging(3, 3).forEach(reply -> System.out.println(reply));
		
		
//		//Member 테스트
//		MemberService svc = new MemberServiceImpl();
//		MemberVO vo = svc.login("user1", "1111");
//		
//		if(vo != null) {
//			System.out.println(vo);
//			System.out.println("환영!!" + vo.getName() + "님. 권한은" + vo.getResponsibility());
//		}else {
//			System.out.println("id, pw 확인");
//		}
		
		
//		SqlSessionFactory factory = DataSource.getInstance();
//		SqlSession session = factory.openSession(true);
//		
//		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
//		// 목록
//		List<BoardVO> list = mapper.selectList();
//		for(BoardVO vo : list) {
//			System.out.println(vo.toString());
//			
//		}
//		
//		
//		// 삽입
//		BoardVO vo = new BoardVO();
//		vo.setTitle("4번 글 삽입해보기");
//		vo.setContent("4번글 내용");
//		vo.setWriter("4번 글 작성자");
//		
//		mapper.insertBoard(vo);
//		
//		// 수정
//		BoardVO vo = new BoardVO();
//		vo.setContent("4번글 수정");
//		vo.setBoardNo(4);
//		
//		if(mapper.updateBoard(vo)==1) {
//			System.out.println("수정성공");
//		}
//				
//		// 단건조회...내가 함 되긴 되는데 교수님꺼 나중에 참고하자
//		BoardVO vo = new BoardVO();
//		vo = mapper.selectOne(2);
//		
//		if(mapper.selectOne(2) != null) {			
//			System.out.println(vo);
//		}
//		
//		
//		// 삭제
//		mapper.deleteBoard(4);
//		if(mapper.deleteBoard(4) ==1) {
//			System.out.println("삭제 성공");
//		}
//		
//		
//		// Cnt
//		if(mapper.updateCnt(2) == 1) {
//			System.out.println("조회수 상승 성공");
//		}
		
		
		
	}//end of main
}
