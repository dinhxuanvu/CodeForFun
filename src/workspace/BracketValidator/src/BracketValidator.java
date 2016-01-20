import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BracketValidator {

	public static void main(String[] args) {
		String test = null;
		System.out.println(bracketValidator(test));
	}

	public static boolean bracketValidator(String str) {
		Map<Character, Character> brackets = new HashMap<Character, Character>();
		List<Character> openers = new ArrayList<Character>();
		List<Character> closers = new ArrayList<Character>();
		LinkedList<Character> stack = new LinkedList<Character>();
		char temp = 0;

		brackets.put('{', '}');
		brackets.put('[', ']');
		brackets.put('(', ')');

		openers.add('{');
		openers.add('(');
		openers.add('[');

		closers.add('}');
		closers.add(')');
		closers.add(']');

		if (str != null) {
			if (str.length() == 0) {
				return true;
			}

			for (int i = 0; i < str.length(); i++) {
				if (openers.contains(str.charAt(i))) {
					stack.add(str.charAt(i));
				} else if (closers.contains(str.charAt(i))) {
					if (stack.size() != 0) {
						temp = brackets.get(stack.getLast());
					}
					if (temp != str.charAt(i)) {
						return false;
					} else {
						stack.removeLast();
					}
					temp = 0;
				}
			}
			if (stack.size() != 0) {
				return false;
			} else
				return true;
		} else
			return false;
	}
	
}
