import java.util.ArrayList;

public class EnhancedForLoopDemo {
	public static void main(String[] args) {
		ArrayList<String> dynamicArray = new ArrayList<String>();
		dynamicArray.add("hello");
		dynamicArray.add("world");
		dynamicArray.add("etc");
		for(String name : dynamicArray){
			System.out.println("hello " + name);
		}
	}
}
