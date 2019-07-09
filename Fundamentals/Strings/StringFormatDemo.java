public class StringFormatDemo {
	public static void main(String[] args) {
		String ninja = String.format("Hi %s, you owe me $%.2f !", "Jack", 25.0);
		System.out.println(ninja);
		// Will print out Hi Jack, you owe me $25.00 !
		// Where %s is expecting a string
		// And %.2f is expecting a float data type. The value 2 will just place two values to the right of the decimal point.
	}
}
