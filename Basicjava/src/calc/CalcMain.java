package problem.calc;

import java.util.Scanner;

// 사친연산이 가능한 계산기 프로그램
public class CalcMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculater calc = new Calculater(); // calc에는 result라는 변수 한개와 함수 네개가 있음
		
		while(true) {
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒ 더하고 나누고 Ver1.0");
			System.out.print("▒▒ 숫자>>");
			int first = sc.nextInt();
			System.out.print("▒▒ 연산자( +, -, x, /)>>");
			sc.nextLine(); // 한줄개행을 막음!
			String oper = sc.nextLine(); // 연산자가 들어감
			System.out.print("▒▒ 숫자>>");
			int second = sc.nextInt();
						
			// System.out.println(first + "," + oper + "," + second);
			int result = 0;
			if(oper.equals("+")) { // 문자열 값은 객체자료형으로 값이 위치한 주소로 가므로 equals를 써야함 
				result = calc.sum(first, second);
				
			} else if(oper.equals("-")) {
				result = calc.sub(first, second);
				
			} else if(oper.equals("*")) {
				result = calc.multi(first, second);
				
			} else if(oper.equals("/")) {
				result = calc.div(first, second);
			}	
			
			// 결과 출력
			System.out.println("▒▒ " + first + oper + second + " = " + result);
		}
	}
}
