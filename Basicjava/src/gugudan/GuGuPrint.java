package gugudan;

public class GuGuPrint {
	
	public void guGuDan(int dansu) {
		int result;  // 변수선언만 되고 초기화는 아직 안 한 상태
		System.out.println("구구단 " + dansu + "단 출력");
		for(int i = 1; i <= 9; i++) {	
			result = dansu * i;
			System.out.println( dansu + " x " + i + " = " + result );	
		}	
		// return이나 }를 만나면 메서드는 끝난다.
	}

}
