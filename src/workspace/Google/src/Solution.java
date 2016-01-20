import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
//		int result = solution(-5,-1);
//		System.out.println(result);
		String str = "";
		String str1 = "abc";
		String str2 = null;
		String str3 = "abca";
		for (int i = 0; i < str3.length(); i++)
		{
			System.out.println(str3.charAt(i));
		}
		System.out.print(uniqueCharacter2(str1));
	}
	
	public static int solution(int A, int B) {
		int currentNumber = 0;
        int count = 0;
        for (int i = A; i < B; i++) {
            currentNumber = i;
            double  result = java.lang.Math.sqrt(currentNumber);
            if (((int) result) == java.lang.Math.ceil(result))
            {
                count++;
            }
        }
        return count;
    }
	
	public static boolean uniqueCharacter(String str) {
		if (str == null || str.isEmpty())
		{
			return true;
		}
		else
		{
			Set<Character> newSet = new HashSet<>();
			for (int i = 0; i < str.length(); i++)
			{
				if (!newSet.add(str.charAt(i)))
				{
					return false;
				}
			}
			return true;
		}
	}
	
	public static boolean uniqueCharacter2(String str) {
		if (str == null || str.isEmpty())
		{
			return true;
		}
		else
		{
			for (int i = 0; i < (str.length()-1); i++)
			{
				for (int x = (i+1); x < str.length(); x++)
				{
					if (str.charAt(i) == str.charAt(x))
					{
						return false;
					}
				}
			}
			return true;
		}
	}
	
	public static boolean stringPermutation(String str1, String str2) {
		if (str1.length() != str2.length())
		{
			return false;
		}
		else
		{
			Map<Character, Integer> newMap1 = new Hashtable<>();
			Map<Character, Integer> newMap2 = new Hashtable<>();
			for (int i = 0; i < str1.length(); i++)
			{
				if (newMap1.containsKey(str1.charAt(i)))
				{
					newMap1.put(str1.charAt(i), newMap1.get(str1))
				}
			}
		}
		return true;
	}
}
