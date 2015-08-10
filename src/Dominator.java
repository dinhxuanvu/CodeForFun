
public class Dominator {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1};
		int[] arr1 = new int[] {};
		int[] arr2 = new int[] {1, 2, 3, 4, 5, 6};
		int[] arr3 = new int[] {1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
		
		System.out.println(findIndexDominator(arr));
	}
	
	/*
	 * Find index of dominator
	 */
	public static int findIndexDominator(int[] numbers) {
		
		if (numbers == null || numbers.length == 0) {
			return -1;
		}
		
		int num = -1;
		int count = 0;
		
		for (int n : numbers) {
			if (count == 0) {
				num = n;
				count++;
			}
			else if (num == n) {
				count++;
			}
			else {
				count--;
			}
		}
		
		count = 0;
		int index = -1;
		for (int i = 0; i < numbers.length; i++) {
			if (num == numbers[i]) {
				count++;
				index = i;
			}
		}
		
		if (count > (numbers.length/2)) {
			return index;
		}
		else
			return -1;
	}
}
