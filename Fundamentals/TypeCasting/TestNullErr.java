public class TestNullErr {
	public static void main(String[] args) {
		Integer a = 10;
		int b = 10;
		a = null;
		b = null;
		// If you try the code above, you will get the following compiling error: incompatible types: <null> cannot be converted to int
	}
}
