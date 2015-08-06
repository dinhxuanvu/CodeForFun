
public class ReverseString {
	
	public static void main(String[] args) {
		String str = "Hello Vu!";
		System.out.println(reverseString(str));
		System.out.println(reverseWord(str));
	}
	
	public static String reverseString(String str) {
		if (str.isEmpty() || str == null) {
			return str;
		}
		else
		{
			StringBuilder newString = new StringBuilder("");
			for (int i = str.length()-1; i >= 0; i--) {
				newString.append(str.charAt(i));
			}
			return newString.toString();
		}
	}
	
	public static String reverseWord(String str) {
		if (str.isEmpty()) {
			return str;
		}
		else {
			String[] split = str.split(" ");
			StringBuilder newString = new StringBuilder("");
			for (int i = split.length - 1; i >= 0; i--) {
				newString.append(split[i]);
				if (i != 0)
					newString.append(" ");
			}
			return newString.toString();
		}
	}
}
