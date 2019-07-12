import java.util.Arrays;
import java.util.ArrayList;

public class PuzzleJavaDemo {
	public static void main(String[] args) {

		PuzzleJava pj = new PuzzleJava();

		int[] int1 = {3,5,1,2,7,9,8,13,25,32};
		System.out.println("Numbers > 10 are "+Arrays.toString(pj.sumAndAboveTen(int1)));

		String[] str1 = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
		System.out.println(Arrays.toString(pj.nameShufflePrintAndFilter(str1)));

		pj.alphabetShuffle();

		System.out.println("The ten random numbers are "+Arrays.toString(pj.tenRandomNumbers()));

		int[] sortedNums = pj.tenRandomNumbersSorted();
		System.out.println("The ten random numbers, sorted, are "+Arrays.toString(sortedNums));
                System.out.println("The minimum value is "+sortedNums[0]+".");
                System.out.println("The maximum value is "+sortedNums[sortedNums.length-1]+".");

		System.out.println("\nCreate a random string of 5 characters.");
		System.out.println(pj.randomString());

		System.out.println(Arrays.toString(pj.tenRandomStrings()));
	}
}
