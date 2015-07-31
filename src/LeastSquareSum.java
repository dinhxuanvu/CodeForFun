
public class LeastSquareSum {
	
	public static void find(int N) {
		int times = 0;
		int min = N;
		double x = 0.0;
		int y = 0;
		for (int i = 1; i < Math.sqrt(N); i++) {
			x = N/(i*i);
			y = N/(i*i);
			System.out.println(x + " " + y);
			if (((double)y) == x) {
				if (min > i) {
					min = y;
					times = i;
				}
			}
		}
		System.out.println(min);
		System.out.println(times);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		find(10);
	}
}
