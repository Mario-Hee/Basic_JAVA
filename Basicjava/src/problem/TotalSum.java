package problem;

public class TotalSum {
	// 1~100중에 짝수, 홀수 각각 더해서 출력하세요
	// 시작값 : 1
	// 종료값: 100
	// 짝수 누적합: even
	// 홀수 누적합: odd
	public static void main(String[] args) {
		int even = 0; // 덧셈한 결과의 누적
		int odd = 0;
		for(int i = 1; i <= 100; i++) {
				if( i % 2 == 0) { // 짝수
					even = even + 1;
				} else { // 홀수
					odd = odd + 1;
				}		
		}		   			    		
				System.out.println("1~100까지 짝수 총합은" + even);
				System.out.println("1~100까지 홀수 총합은" + odd);
		
	}

}
