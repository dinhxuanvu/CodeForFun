
public class IsNumeric {
	
	public static void main(String[] args) {
		
		String str = "99.99";
		String str1 = "9.99a";
		String str2 = "";
		String str3 = "a";
		String str4 = "01";
		
		System.out.println(isNumeric(str4));
		
		
	}
	
	public static boolean isNumeric(String str) {
		return str.matches("\\d+(\\.\\d+)?");
	}

}
