package chapter12;

import java.util.HashMap;

public class HashMap01 {
	public static void main(String[] args) {
		HashMap < String, Object > map = new HashMap<>(); // Object는 모든 값을 받는다
		//         Key  ,  Value 
		map.put("몽몽이", "초코"); // HashMap에선 값을 입력할때 add가 아닌 put이라고 한다.
		map.put("냥냥이", "젤리");
		System.out.println(map.get("냥냥이")); // Key를 입력 함으로써(요청함으로써) 값을 받을 수 있다.
	}
}
