package problem;

public class Fibonacci {
	public static void main(String[] args) {
	int first = 1;
	int end = 1;
	int sum;
	System.out.print(first);
	System.out.print(end);
	for(int i = 1; i <= 5; i++) {
		sum = first + end;
		System.out.print(sum);
		first = end;
		  end = sum;			
	}
	
	}

}
	