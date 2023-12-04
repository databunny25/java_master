package chap11.object;

import todo.p20231128.Board;

public class StringExe {
	public static void main(String[] args) {

		String[] fileNames = { "c:/images/prod/sample.jpg", "d:/test/sample/americano.png",
				"d:/goods/test/2023/moka.jpg" };
		for (String file : fileNames) {
			System.out.println(findFileName(file));
		}

		String[] numbers = { "980304-1234567", "980304-2234567", "020104-4456789", "0301053545678" };
		for (String no : numbers) {
			System.out.println(findGender(no));
		}

		byte[] b1 = "Hello".getBytes();
		for (byte b : b1) {
			System.out.println(b);
		}

		String name = new String(new byte[] { 65, 66, 67, 68, 69 });
		name = new String(b1);
		System.out.println(name);

		char c1 = name.charAt(0);
		System.out.println(c1);
	}

	// 성별을 반환
	static String findGender(String ssn) {
		// 생년월일 -1,2,3,4
		
//		내가한거....망함 ㅠㅠ
//		if(ssn.substring(7,8).equals("-")) {
//			if(ssn.substring(7,8).equals("1") || ssn.substring(7,8).equals("3")) {
//				ssn = "남";
//			}else {
//				ssn = "여";
//			}
//		}else {
//			if(ssn.substring(8,9).equals("1") || ssn.substring(8,9).equals("3")) {
//				ssn = "남";
//			}else {
//				ssn = "여";
//			}
//		}		
//		
//		return ssn;	
		
		
		
		int pos = ssn.length() -7;
		switch(ssn.charAt(pos)) {
		case '1':
		case '3':
			return "남";
		case '2':
		case '4':
			return "여";
		}
		return "오류";
		
			
	}// end of findGender.

	
	
	// 파일명을 가져오기
	static String findFileName(String file) {

//		내가 함
//		return file.substring(file.lastIndexOf("/")+1);

		int pos = 0;
		while (true) {
			int pos2 = file.indexOf("/", pos);
			if (pos2 == -1) {
				break;
			}
			pos2++;
			pos = pos2;
		}
		return file.substring(pos);

	}

}// end of Class
