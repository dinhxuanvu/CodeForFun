
public class FindDuplicatesLinear {
	
	public static void main(String[] args) {
		int[] test = new int[] {1, 2, 3, 1, 3, 0, 6};
		findDuplicates(test);
	}
	
	
	public static void findDuplicates(int[] num) {
		for (int i = 0; i < num.length; i++) {
			while (num[num[i]] != num[i]) {
				swap(num, i, num[i]);
			}
		}
		
		for (int i = 0; i < num.length; i++) {
			if (num[i] != i && num[num[i]] == num[i]) {
				System.out.println(num[i]);
				num[num[i]] = i;
			}
		}
	}

	private static void swap(int[] num, int x, int y) {
		int temp = num[x];
		num[x] = num[y];
		num[y] = temp;
	}
}
