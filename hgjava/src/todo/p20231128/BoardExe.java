package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

//저장소: boards
public class BoardExe {
	// BoardExe 클래스 : 데이터를 담기(X) 저장된 데이터를 처리하고 여러 기능들을 구현하기 위한 용도
	static Board[] boards;

	BoardExe() {
		// boards = new Board[100];
	}

	static {
		boards = new Board[100];
	}
	
	// 초기값 생성
	public static void initData() {
		boards[0] = new Board(1, "첫번째 글", "user01", "첫번째 글 입력중이야", "23-11-29");
		boards[1] = new Board(2, "두번째 글", "user02", "두번째 글 입력중이야", "23-11-30");
		// boards[2] <----- 5번글
		boards[3] = new Board(4, "네번째 글", "user04", "네번째 글 입력중이야", "23-12-02");
		boards[2] = new Board(3, "세번째 글", "user03", "네번째 글 입력중이야", "23-12-02");
		boards[4] = new Board(5, "다섯번째 글", "user05", "네번째 글 입력중이야", "23-12-02");
		boards[5] = new Board(6, "여섯번째 글", "user06", "네번째 글 입력중이야", "23-12-02");
		boards[6] = new Board(7, "일곱번째 글", "user07", "네번째 글 입력중이야", "23-12-02");		
		boards[7] = new Board(8, "여덟번째 글", "user08", "세번째 글 입력중이야");
	}

	// 등록. 글번호/제목/작성자/내용/작성일자 => 반환값: boolean
	public static boolean addBoard(Board board) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
				return true; // 반복문 종료
			}
		}
		return false;
	}

	// 목록 반환값: 배열
	public static Board[] boardList() {
		// boards = 새로운 배열에 정렬된 값으로 반환.

		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			// 위치변경작업
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i] != null && boards[i + 1] != null) {
					if (boards[i].getNo() > boards[i + 1].getNo()) {
						temp = boards[i];
						boards[i] = boards[i + 1];
						boards[i + 1] = temp;
					}
				}
			}
		}

		return boards;
	}//end of boardList();
	
	// 배열, 페이지 => 페이지의 5건을 반환
	public static Board[] pageList(Board[] ary, int page) {
		Board[] resultAry = new Board[5];
		
		int start = (page - 1) * 5;
		int end = page *5;
		int j=0; 
		for (int i = 0; i <ary.length; i++) {
			if(i >= start && i < end) {
				resultAry[j++] = ary[i];
			}
		}
		return resultAry;
	}

	// 단건조회. 매개변수: 글번호, 반환값: Board
	public static Board getBoard(int boardNo) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getNo() == boardNo) {
				return boards[i];
			}
		}
		return null;
	}

	// 신규번호 : 현재 글번호+1
	public static int getSequence() {
		int seqNo = 1;
		// 배열에서 글번호의 max가져오기
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getNo() > max) {
				max = boards[i].getNo();
			}
		}
		seqNo = max + 1;
		return seqNo;
	}

	// 수정. 매개값(글번호, 내용) => 잘 수정되었는지 boolean 값으로 반환
	public static boolean modBoard(int contentNo, String content) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getNo() == contentNo) {
				boards[i].setContents(content);
				boards[i].setDate(sdf.format(today));
				return true;
			}
		}
		return false;
	}

	// 삭제. 매개값(글번호) => boolean
	public static boolean remBoard(int contentNo) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getNo() == contentNo) {
				boards[i] = null;
				return true;
			}
		}
		return false;
	}

	//사용자가 해당글번호의 수정, 삭제권한 체크 => boolean
	public static boolean checkResponsibility(String id, int no) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getNo() == no && boards[i].getUser().equals(id)) {
				return true;
			}
		}
		return false;
	}//end of checkResponsibility
	
	//게시글을 담고 있는 배열에서 값이 있는 건수를 반환 (null값 제외한 전체 게시글 개수 알아보기)
	public static int getBoardCount() {
		int realCnt = 0;
		for ( int i= 0; i < boards.length; i++) {
			if(boards[i] != null) {
				realCnt++;
			}
		}
		return realCnt;
	}
	
	
	
	
	
}