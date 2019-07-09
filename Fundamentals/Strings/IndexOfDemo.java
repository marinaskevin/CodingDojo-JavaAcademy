public class IndexOfDemo {
	public static void main(String[] args) {
		String ninja = "Welcome to Coding Dojo!";
		int a = ninja.indexOf("Coding"); // a is 11
		int b = ninja.indexOf("co"); // b is 3
		int c = ninja.indexOf("pizza"); // c is -1, "pizza" is not found
		System.out.println("a is "+a);
		System.out.println("b is "+b);
		System.out.println("c is "+c);
	}
}
