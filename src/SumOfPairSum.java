
public class SumOfPairSum {

	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4};
		System.out.println(sumPairs(numbers));
	}
	
	public static int sumPairs(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return 0;
		}
		int n = numbers.length;
		int sum = 0;
		for (int num : numbers) {
			sum = sum + num*(n-1);
		}
		return sum;
	}

}
