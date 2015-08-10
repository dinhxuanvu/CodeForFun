import java.util.Arrays;

public class ThreeSumDeluxe {

	public static int count(int[] a) {
		int n = a.length;
		int count = 0;
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (search(a,-(a[i]+a[j])) != -1) {
					count++;
				}
			}
		}
		return count;
	}

	public static int search(int[] a, int key) {

		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			// int mid = (high + low)/2 >>> 1;
			if (key < a[mid])
				high = mid - 1;
			else if (key > a[mid]) {
				low = mid + 1;
			} else
				return mid;
		}
		return -1;
	}

}
