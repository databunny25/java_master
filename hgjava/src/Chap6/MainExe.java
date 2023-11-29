package Chap6;

public class MainExe {

	public static void main(String[] args) {
		
		String[] strs = {"1.adk", "2.dfls", "3.skdjf", "4.skdjfk", "5.sdlkfj", "6.sdkjfdk", "7.skdfjkd", "8.sdkfj"};
		int page = 1;
		int start = (page - 1) * 5;
		int end = page *5;
		
		for (int i = 0; i <strs.length; i++) {
			if(i >= start && i < end) {
			System.out.println(strs[i]);
			}
		}
		
		int cnt = 36;
		
		int totalPage = (int)Math.ceil(cnt/5.0);
		System.out.println(totalPage);
		
		for(int i=1; i <=totalPage; i++) {
			System.out.print(i + " ");
		}

	}

}
