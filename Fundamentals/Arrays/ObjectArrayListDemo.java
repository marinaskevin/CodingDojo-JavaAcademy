import java.util.ArrayList;

public class ObjectArrayListDemo {
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(10);
		list.add("Hello");
		list.add(new ArrayList<Integer>());
		list.add(new Double(12.0));
		System.out.println(list);
	}
}
