
public class MergeSort {
	
	public static void merge(Comparable[] a, Comparable[] temp, int lo, int mid, int hi) {

		for (int k = 0; k <= hi; k++) {
			temp[k] = a[k];
		}
		
		int i = lo; 
		int j = mid+1;
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = temp[j++];
			else if (j > hi)
				a[k] = temp[i++];
			else if (less(temp[j],temp[i]))
				a[k] = temp[j++];
			else
				a[k] = temp[i++];
		}

	}
	
	public static void sort(Comparable[] a, Comparable[] temp, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi-lo)/2;
		sort(a,temp,lo,mid);
		sort(a,temp,mid+1,hi);
		merge(a,temp,lo,mid,hi);
	}
	
	public static void merge2(Comparable[] a, Comparable[] temp, int lo, int mid, int hi) {
		
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
	
	public static void sort2(Comparable[] a, Comparable[] temp, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi-lo)/2;
		sort(temp,a,lo,mid);
		sort(temp,a,mid+1,hi);
		merge(a,temp,lo,mid,hi);
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

}
