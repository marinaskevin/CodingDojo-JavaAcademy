import java.util.ArrayList;

public class ForLoopDemo {
	public static void main(String[] args) {
		for (int i=0; i < 7; i++){
			System.out.println("bar");
		}
		// for(initialization; termination; increment){
		// 	body statments
		// }}
		ArrayList<String> dynamicArray = new ArrayList<String>();
		dynamicArray.add("hello");
		dynamicArray.add("world");
		dynamicArray.add("etc");
		for (int i = 0; i < dynamicArray.size(); i++){
			System.out.println(dynamicArray.get(i));
		}
	}
}
