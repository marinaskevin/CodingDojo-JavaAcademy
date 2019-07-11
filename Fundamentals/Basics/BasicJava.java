import java.util.ArrayList;

public class BasicJava {
	public static void print1to255() {
		System.out.println("\nPrint 1-255");
		for(int i=1; i<256; i++){
			System.out.print(i+" ");
		}
		System.out.print("\n");
	}
	public static void printOdd1to255() {
		System.out.println("\nPrint odd numbers between 1-255");
		for(int i=1; i<256; i+=2){
			System.out.print(i+" ");
		}
		System.out.print("\n");
	}
	public static void printSum() {
		System.out.println("\nPrint Sum");
		int sum = 0;
		for(int i=0; i<256; i++){
			sum += i;
			System.out.printf("New number: %d Sum: %d\n",i,sum);
		}
	}
	public static void iterateArray(int[] array) {
		System.out.println("\nIterating through an array");
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
	public static void findMax(int[] array) {
		System.out.println("\nFind Max");
		if(array.length == 0) return;
		int max = array[0];
		for(int i=1; i<array.length; i++) {
			if(array[i] > max) max = array[i];
		}
		System.out.printf("The maximum value in the array is %d",max);
		System.out.print("\n");
	}
	public static void getAverage(int[] array) {
		System.out.println("\nGet Average");
		if(array.length == 0) return;
		float sum = 0;
		for(int i=0; i<array.length; i++) {
			sum += array[i];
		}
		System.out.printf("The average value is %.2f",sum/array.length);
		System.out.print("\n");
	}
	public static ArrayList<Integer> oddNumberArray() {
		System.out.println("\nArray with Odd Numbers");
		ArrayList<Integer> y = new ArrayList<Integer>();
		for(int i=1; i<256; i+=2){
			y.add(i);
		}
		return y;
	}
	public static Integer greaterThanY(int[] array, int y) {
		System.out.println("\nGreater than Y");
		if(array.length == 0) return null;
		int gt = 0;
		for(int i=0; i<array.length; i++){
			if(array[i] > y) gt++;
		}
		return gt;
	}
	public static int[] squaredValues(int[] array) {
		System.out.println("\nSquare the values");
		int[] new_array = new int[array.length];
		for(int i=0; i<array.length; i++){
			new_array[i] = array[i] * array[i];
		}
		return new_array;
	}
	public static int[] noNegativeValues(int[] array) {
		System.out.println("\nEliminate Negative Numbers");
		int[] new_array = new int[array.length];
		for(int i=0; i<array.length; i++){
			if(array[i] < 0) new_array[i] = 0;
			else new_array[i] = array[i];
		}
		return new_array;
	}
	public static Object[] maxMinAvg(int[] array) {
		System.out.println("\nMax, Min, and Average");
		if(array.length == 0) return null;
		int max = array[0];
		int min = array[0];
		float sum = 0;
		for(int i=0; i<array.length; i++){
			if(array[i] > max) max = array[i];
			if(array[i] < min) min = array[i];
			sum += array[i];
		}
		Object[] answers = {max,min,sum/array.length};
		return answers;
	}
	public static int[] arrayShift(int[] array) {
		System.out.println("\nShift the Values in the Array");
		int[] new_array = new int[array.length];
		for(int i=0; i<array.length-1; i++){
			new_array[i] = array[i+1];
		}
		new_array[array.length-1] = 0;
		return new_array;
	}
}
