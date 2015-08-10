
public class PositionProduct {
	public static void main(String[] args) {
		int[] numbers = new int[] {1,3,5,2,8,0,-1,3};
		int[] numbers2 = new int[] {0,-1,3,100,-70,-50};
		System.out.println(findMaxProduct(numbers));
		System.out.println(findMaxProduct2(numbers2));
	}
	
	public static int findMaxProduct(int[] numbers) {
		if (numbers == null || numbers.length < 3) {
			return 0;
		}
		else {
			int n = numbers.length;
			int product = 0;
			int temp = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					for (int m = j + 1; m < n; m++) {
						temp = numbers[i]*numbers[j]*numbers[m];
						if (temp > product) {
							product = temp;
						}
					}
				}
			}
			if (product > 0) {
				return product;
			}
			else
				return 0;
		}
	}
	
	public static int findMaxProduct2(int[] numbers) {
		if (numbers == null || numbers.length < 3) {
			return 0;
		}
		else {
			// Find 3 biggest & 2 smallest: 0 1 2 / 3 4
			int[] list = new int[5];
			for (int num : numbers) {
				if (num > list[0]) {
					list[2] = list[1];
					list[1] = list[0];
					list[0] = num;
				}
				else if (num > list[1]) {
					list[2] = list[1];
					list[1] = num;
				}
				else if (num > list[2]) {
					list[2] = num;
				}
				else if (num < list[4]) {
					list[3] = list[4];
					list[4] = num;
				}
				else if (num < list[3]) {
					list[3] = num;
				}
			}
			// A*(B*C or D*E)
			return list[0]*Math.max(list[1]*list[2], list[3]*list[4]);
		}
	}

}
