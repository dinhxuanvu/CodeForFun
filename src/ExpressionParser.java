import java.util.LinkedList;


class SimpleStack<Item> {
	Node first = null;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(Item item) {
		Node old = first;
		first = new Node();
		first.item = item;
		first.next = old;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		return item;
	}
}

public class ExpressionParser {

	public static void main(String[] args) {
		String test = "( ( ( 3.0 + 1.0 ) / 3 ) * 5 )";
		System.out.println(evaluate(test));
		System.out.println(evaluate2(test));
	}

	public static double evaluate(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		LinkedList<String> expression = new LinkedList<String>();
		LinkedList<Double> numbers = new LinkedList<Double>();

		String[] arr = str.split(" ");

		for (String item : arr) {
			if (item.equals("(")) {

			} else if (item.equals("+")) {
				expression.add(item);
			} else if (item.equals("-")) {
				expression.add(item);
			} else if (item.equals("/")) {
				expression.add(item);
			} else if (item.equals("*")) {
				expression.add(item);
			} else if (item.equals(")")) {
				String op = expression.removeLast();
				if (op.equals("+")) {
					numbers.add(numbers.removeLast() + numbers.removeLast());
				}
				else if (op.equals("-")) {
					double temp = numbers.removeLast();
					numbers.add(numbers.removeLast() - temp);
				}
				else if (op.equals("/")) {
					double temp = numbers.removeLast();
					numbers.add(numbers.removeLast() / temp);
				}
				else {
					numbers.add(numbers.removeLast() * numbers.removeLast());
				}
			} else {
				if (item.matches("\\d+(\\.\\d+)?")) {
					numbers.add(Double.parseDouble(item));
				}
			}
		}
		return numbers.remove();
	}
	
	public static double evaluate2(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		SimpleStack<String> expression = new SimpleStack<String>();
		SimpleStack<Double> numbers = new SimpleStack<Double>();

		String[] arr = str.split(" ");

		for (String item : arr) {
			if (item.equals("(")) {

			} else if (item.equals("+")) {
				expression.push(item);
			} else if (item.equals("-")) {
				expression.push(item);
			} else if (item.equals("/")) {
				expression.push(item);
			} else if (item.equals("*")) {
				expression.push(item);
			} else if (item.equals(")")) {
				String op = expression.pop();
				if (op.equals("+")) {
					numbers.push(numbers.pop() + numbers.pop());
				}
				else if (op.equals("-")) {
					double temp = numbers.pop();
					numbers.push(numbers.pop() - temp);
				}
				else if (op.equals("/")) {
					double temp = numbers.pop();
					numbers.push(numbers.pop() / temp);
				}
				else {
					numbers.push(numbers.pop() * numbers.pop());
				}
			} else {
				if (item.matches("\\d+(\\.\\d+)?")) {
					numbers.push(Double.parseDouble(item));
				}
			}
		}
		return numbers.pop();
	}

}
