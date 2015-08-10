
public class FixedStack {
	
	private String[] str;
	private int N = 0;
	
	public FixedStack() {
		str = new String[1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(String item) {
		if (N == str.length) {
			resize(str.length * 2);
		}
		str[N++] = item;
	}
	
	public String pop() {
		String item = str[--N];
		if (N > 0 && N == str.length/4)
			resize(str.length/4);
		str[N] = null;
		return item;
	}
	
	private void resize(int capacity) {
		String[] copy = new String[capacity];
		for (int i = 0; i < str.length; i++) {
			copy[i] = str[i];
		}
		str = copy;
	}

}
