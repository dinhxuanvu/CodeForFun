
public class PrimeNumber {
	
	public static void main(String[] args) {
		findPrime(100);
	}
	
	public static void findPrime(int n) {
		for (int i = 1; i < n; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime == true) {
				System.out.print(i + " ");
			}
		}
	}

}
