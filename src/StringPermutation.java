import java.util.HashSet;

public class StringPermutation {
	
	public static void main(String[] args) {
		String test = "abc";
		permutation(test);
	}

	public static void permutation(String str) {
		HashSet<String> result = new HashSet<String>();
		perm("", str, result);
		for (String s : result) {
			System.out.println(s);
		}
	}

	private static void perm(String prefix, String str, HashSet<String> result) {
		int size = str.length();
		if (size == 0) {
			result.add(prefix);
		} else {
			for (int i = 0; i < size; i++) {
				perm(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), result);
			}
		}
	}

}
