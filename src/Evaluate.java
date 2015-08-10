public class Evaluate {

	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> values = new Stack<Double>();
		
		while (!StdIn.isEmpty()) {
			String str = StdIn.readString();
			if (str.equals("(")) {
				
			}
			else if (str.equals("+")) {
				ops.push(str);
			}
			else if (str.equals("-")) {
				ops.push(str);
			}
			else if (str.equals("*")) {
				ops.push(str);
			}
			else if (str.equals("/")) {
				ops.push(str);
			}
			else if (str.equals(")")) {
				String op = ops.pop();
				if (op.equals("+")) {
					values.push(values.pop() + values.pop());
				}
				else if (op.equals("-")) {
					values.push(values.pop() - values.pop());
				}
				else if (op.equals("*")) {
					values.push(values.pop() * values.pop());
				}
				else if (op.equals("/")) {
					values.push(values.pop() / values.pop());
				}
			}
			else
				values.push(Double.parseDouble(str));
		}
		System.out.println(values.pop());
	}

}
