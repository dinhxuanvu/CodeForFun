
public class TypeCast {

	public static void main(String[] args) {

		int integer_type = 9;
		long long_type = 19;
		float float_type = 999;
		double double_type = 9999;
		
		System.out.println(integer_type/float_type);
		System.out.println(integer_type/double_type);
		System.out.println(integer_type/long_type);
		
		System.out.println(float_type/integer_type);
		System.out.println(double_type/integer_type);
		System.out.println(long_type/integer_type);
		
		System.out.println(float_type/double_type);
		System.out.println(double_type/float_type);
		System.out.println(long_type/double_type);
		
	}

}
