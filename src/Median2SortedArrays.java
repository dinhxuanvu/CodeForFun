
public class Median2SortedArrays {
	/*
	 * Same size n
	 */
	public static int getMedian(int[] A, int[] B) {
		int i = 0;
		int j = 0;
		int count;
		int m1 = 0;
		int m2 = 0;
		int n = A.length;
		
		// For different size case
//		int n = A.length + B.length;
//		if (n % 2 == 0) {
//			n = n/2;
//		}
//		else
//			n = (n/2 + 1);
		
		for (count = 0; count <= n; count++) {
			if (i == n) {
				m1 = m2;
				m2 = B[0];
				break;
			}
			else if (j == n) 
			{
				m1 = m2;
				m2 = A[0];
			}
			
			if (A[i] < B[j]) {
				m1 = m2;
				m2 = A[i];
			}
			else
			{
				m1 = m2;
				m2 = B[j];
			}
		}
		return ((m1+m2)/2);
	}

}
