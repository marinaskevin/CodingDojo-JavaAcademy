public class EqualityDemo {
	public static void main(String[] args) {
		String a = new String("word");
		String b = new String("word");
		System.out.println(a == b); // false. not the same exact object.
		System.out.println(a.equals(b)); // true. same exact characters.
	}
}
