import java.util.Arrays;
import java.util.ArrayList;

public class BasicJavaDemo {
	public static void main(String[] args){
		BasicJava basic = new BasicJava();
		basic.print1to255();
		basic.printOdd1to255();
		basic.printSum();
		int[] int1 = {1,3,5,7,9,13};
		int[] int2 = {-3, -5, -7, -1};
		int[] int3 = {2, 10, 3};
		int[] int4 = {1,3,5,7};
		int[] int5 = {1, 5, 10, -2};
		int[] int6 = {1, 5, 10, 7, -2};
                basic.iterateArray(int1);
                basic.findMax(int2);
                basic.getAverage(int3);
                ArrayList<Integer> y = basic.oddNumberArray();
                System.out.println(y);
		System.out.println(basic.greaterThanY(int4,3));
		System.out.println(Arrays.toString(basic.squaredValues(int5)));
		System.out.println(Arrays.toString(basic.noNegativeValues(int5)));
		System.out.println(Arrays.toString(basic.maxMinAvg(int5)));
		System.out.println(Arrays.toString(basic.arrayShift(int6)));
	}
}
