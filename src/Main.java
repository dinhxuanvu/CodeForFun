
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(Integer.toBinaryString(n));
		
		int bits = (n >> 1) & 1;
		System.out.println(bits);
	}
}