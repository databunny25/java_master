package Chap7;

public class FriendExe {
	Friend[] storage = new Friend[10];
	
	//1.등록 2.목록 3.조회
	
	boolean addFriend(Friend friend) {
		for(int i = 0 ; i < storage.length ; i++) {
			if(storage[i] == null) {
				storage[i] = friend;
				return true;
			}
		}
		return false;
	}
	
	Friend[] friendList() {		
		return storage;
	}
	
	//결과값이 null여부로 체크(X) (반환유형이 배열 result로 정해져있기 때문에~~) 
	public Friend[] searchFriend(String name) {
		//반환유형이 정해져있음.
		Friend[] result = new Friend[10];
		int num = 0;
		for(int i = 0; i < storage.length ; i++) {
			if(storage[i] != null && storage[i].getName().equals(name){
				result[num++] = storage[i];
			}
		}
		
		
		return result;
	}
	
	//결과값이 null여부로 체크(O)
	public Friend searchPhone(String phone) {
		return null;
	}
}
