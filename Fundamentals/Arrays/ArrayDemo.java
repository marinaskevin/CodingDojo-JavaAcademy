import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		int[] myArray;
		myArray = new int[5];
		myArray[0] = 4;
		myArray[1] = 8;
		myArray[2] = 8;
		myArray[3] = 5;
		myArray[4] = 9;
		System.out.println(Arrays.toString(myArray));
                int[] myArray2 = {4, 8, 8, 5, 9};
		System.out.println(Arrays.toString(myArray2));
	}
}
