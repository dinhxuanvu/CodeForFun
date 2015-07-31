import java.util.HashSet;


public class SumCombination {
	
	public static void main(String[] args) {
		findCombination(4);
	}
	
	public static void findCombination(int n) {
		if (n > 0) {
			HashSet<String> result = new HashSet<String>();
			for (int i = 1; i <= n; i++) {
				findSumCombination(result, "", i, n, n);
			}
			for (String str : result) {
				System.out.println(str);
			}
		}
	}

	private static void findSumCombination(HashSet<String> result, String str, int current, int remain, int n) {
		if (remain < 0) {
			return;
		}
		else if (remain == 0) {
			result.add(str);
			return;
		}
		
		//System.out.println(str);
		str += current + " ";
		remain = remain - current;
		
		for (int j = current; j <= n; j++) {
			findSumCombination(result, str, j, remain, n);
		}
	}
}
