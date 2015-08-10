
public class Fibonacci {
	
	public static void main(String[] args) {
		System.out.println(fab(5));
		System.out.println(fabNonRe(5));
	}
	
	// Recursive version
	public static int fab(int n) {
		if (n < 2) {
			return 1;
		}
		else {
			return (fab(n-2) + fab(n-1));
		}
	}
	
	// Non-recursive version
	public static int fabNonRe(int n) {
		if (n < 2) {
			return 1;
		}
		else {
			int firstNum = 1;
			int secondNum = 1;
			int sum = 0;
			for (int i = 2; i <= n; i++) {
				sum = firstNum + secondNum;
				firstNum = secondNum;
				secondNum = sum;
			}
			return sum;
		}
	}

}
