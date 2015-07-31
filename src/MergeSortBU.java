
public class MergeSortBU {
	
	private static Comparable[] temp;
	
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		
		int i = lo; 
		int j = mid+1;
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				temp[k] = a[j++];
			else if (j > hi)
				temp[k] = a[i++];
			else if (less(a[j],a[i]))
				temp[k] = a[j++];
			else
				temp[k] = a[i++];
		}

	}
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		temp = new Comparable[N];
		for (int size = 1; size < N; size = size+size) {
			for (int lo = 0; lo < N - size; lo += size + size) {
				merge(a,lo,lo+size-1,Math.min(lo+size+size-1, N-1));
			}
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
}
