
public class ReverseBinaryInt {
	
	public static void main(String[] args) {
		System.out.println(Long.toBinaryString(reverseBinaryInt(1)));
		System.out.println(Long.toBinaryString(reverseBinaryInt(1)).toCharArray().length);
	}
	
	public static long reverseBinaryInt(long x) {
		long r = 0;
	    for (int i = 63; i >= 0; i--) {
	        r |= ((x >>> i) & 0x1L) << (63 - i);
	    }
	    return r;
	}

}
