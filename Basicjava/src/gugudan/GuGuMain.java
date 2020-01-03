package gugudan;

import java.util.Scanner;	

public class GuGuMain {
	
	public static void main(String[] args) {
		// java는 프로그램 실행시 무조건
	    // Main 메서드부터 시작!!!
				
		// 구구단 2단 출력
		// 2 x 1 = 2
		// 2 x 2 = 4
		// 2 x 3 = 6
		// 2 x 4 = 8
		// 2 x 5 = 10
		// 2 x 6 = 12
		// 2 x 7 = 14
		// 2 x 8 = 16
		// 2 x 9 = 18	
		// 3 x 1 = 3
		// 4 x 1 = 4
		
		// 1. 사용자에게 단수를 입력 받는 부분
		// 2. 구구단을 출력하는 부분
		
		Scanner sc = new Scanner(System.in);  //객체 생성, 자바에서 만들어 놓은 클래스
		System.out.print("단수>>"); 
		int dansu = sc.nextInt(); // 단수 입력 , 인스턴스(결과물)사용, 
		                          // 사용자가 키보드로 입력한 정수값을 가져와라
		GuGuPrint ggp = new GuGuPrint();
		ggp.guGuDan(dansu); // (호출문) (guGuPrint)에 갔다가 다시(return) 오는 것, 다시 호출함
		                              // (매개변수)
	}
}
