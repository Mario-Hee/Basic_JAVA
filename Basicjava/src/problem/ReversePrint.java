package problem;

import java.util.Scanner;

public class ReversePrint {
	// 조건
	// 1. 사용자가 임의의 정수를 입력
	// 2. 사용자가 입력한 정수를 1부터 끝까지 출력
	// 출력 예제
	// 입력>> 5
	// 1
	// 2
	// 3
	// 4
	// 5
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("▒▒입력>> ");
		// num = 사용자가 키보드로 입력한 정수값
		
		int num = sc.nextInt(); //입력값
		int finalNum = num; //종료값
		 
		num = num + 1;
		for(int i = 1 ; i <= finalNum; i++) {  
			num = num - 1;
		     System.out.println(num);// 1번		
		  
		}
		
	}
	
	
	


	
	 


	
	
	
		
		


}
