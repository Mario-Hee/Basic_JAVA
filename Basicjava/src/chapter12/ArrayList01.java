package chapter12;

import java.util.ArrayList;

public class ArrayList01 {
	public static void main(String[] args) {
		// ArrayList는 사이즈가 고정되지 않고 유동적이다!!
		ArrayList<String> list = new ArrayList<>(); // 다이아몬드 연산자< >는 쓰고 안의 값은 안써도 된다.
		list.add("딸기"); // 값 입력 0번지 딸기 add는 값을 등록하는것 (등록은 index값이 있어도 그만 없어도 그
		list.add("포도"); // 값 입력 1번지 포도 ( index 번호가 없으면 배열의 맨 마지막에 값이 붙는다)
		list.add("체리"); // 값 입력 2번지 체리 ( index 번호가 있으면 값이 하나씩 밀린다.)
		list.add(2, "자몽"); // (index, value) 값을 한 칸씩 옆으로 민다.
		list.set(1, "바나나"); // 3번지의 체리를 바나나로 바꿈 set은 값을 수정하는 것(index값을 수정해야한다)
		list.remove(3); // remove 값을 지우는 것(반드시 index값을 지워야한다)
		
		int[] array = new int[5];
		array[0] = 3;
		
		// 출력
		for (int i = 0; i < list.size(); i++) { // list는 length가 아니라 size이다!!!
			System.out.println(list.get(i)); // get은 값을 꺼내오는것 조회하는것(반드시 index값을 꺼내와야한다)
			// System.out.println(array[i]); 
			// 둘 다 가져오는 건 같다.
		}
		for (String val : list) { // 향상된 for문 : Foreach (한번씩 꺼내서 쓸 때만 전체 다 출력 할 때만 쓰인다!!)
			System.out.println(val);
			
		}
	}
}
