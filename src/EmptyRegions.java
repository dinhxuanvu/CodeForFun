
public class EmptyRegions {
	
	public static void findRegions(int[] A, int[] B) {
	
		int current = 0;
		int head = -1;
		for (int i = 0; i < B.length; i++) {
			head = B[i];
			for (int j = current; j < B[i]; j++) {
				System.out.println(A[j]);
			}
			System.out.println("---");
			current = head + 1;
		}
		if (head != -1 && head < A.length) {
			for (int i = current; i < A.length; i++) {
				System.out.println(A[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[100];
		for (int i = 0; i < 100; i++) {
			A[i] = i;
		}
		
		int[] B = new int[] {1,5,45,86};
		
		findRegions(A,B);
	}
}
