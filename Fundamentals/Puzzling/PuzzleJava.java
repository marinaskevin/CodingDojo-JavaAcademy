import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
	public static int[] sumAndAboveTen(int[] array) {
		System.out.println("\nGiven an array of numbers "+Arrays.toString(array));
		System.out.println("Print sum and return an array of numbers > 10");
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		int sum = 0;
		for(int i = 0; i<array.length; i++){
			sum += array[i];
			if(array[i] > 10) newArray.add(array[i]);
		}
		System.out.printf("The sum is %d.\n",sum);
		int[] gt10Array = new int[newArray.size()];
		for(int i=0; i<newArray.size(); i++){
			gt10Array[i] = newArray.get(i);
		}
		return gt10Array;
	}
	public static String[] nameShufflePrintAndFilter(String[] array) {
		System.out.println("\nGiven an array of names "+Arrays.toString(array));
		System.out.println("Shuffle names and print them, then return names longer than 5 characters.");
		ArrayList<String> newArray = new ArrayList<String>(Arrays.asList(array));
		Collections.shuffle(newArray);
		System.out.println(newArray);
		newArray.removeIf(name -> name.length() < 6);
		String[] longNames = new String[newArray.size()];
		for(int i=0; i<newArray.size(); i++){
			longNames[i] = newArray.get(i);
		}
		return longNames;
	}
	public static void alphabetShuffle() {
		System.out.println("\nGiven the alphabet, shuffle it and select the first and last letters. If the first letter is a vowel, print a special message.");
		char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		ArrayList<Character> abcArray = new ArrayList<Character>();
		for(char c : abc){
			abcArray.add(c);
		}
		System.out.println("Unshuffled array: "+abcArray);
		Collections.shuffle(abcArray);
		System.out.println("Shuffled array: "+abcArray);
		System.out.println("First letter: "+abcArray.get(0).charValue());
		if("aeiou".contains(abcArray.get(0)+""))
			System.out.println("*** CONGRATULATIONS!!! YOU'VE STARTED WITH A VOWEL!!! ***");
		System.out.println("Last letter: "+abcArray.get(abcArray.size()-1));
	}
	public static int[] tenRandomNumbers() {
		System.out.println("\nGenerate 10 random numbers from the range 55-100 and return them in an array.");
		Random r = new Random();
		int[] nums = new int[10];
		for(int i=0; i<10; i++) {
			nums[i] = r.nextInt(46)+55;
		}
		return nums;
	}
	public static int[] tenRandomNumbersSorted() {
		int[] nums = tenRandomNumbers();
		System.out.println(Arrays.toString(nums));
		System.out.println("Now sort them. Also show min and max values.");
		ArrayList<Integer> sortedNums = new ArrayList<Integer>();
		for(int num : nums) {
			sortedNums.add(num);
		}
		Collections.sort(sortedNums);
		nums = new int[sortedNums.size()];
		for(int i=0; i<sortedNums.size(); i++)
		{
			nums[i] = sortedNums.get(i);
		}
		return nums;
	}
	public static String randomString() {
		Random r = new Random();
		char[] randStr = new char[5];
		for(int i=0; i<5; i++){
			randStr[i] = (char)(r.nextInt(94)+33);
		}
		return (new String(randStr));
	}
	public static String[] tenRandomStrings() {
		System.out.println("\nCreate an array of ten random strings of 5 characters each.");
		String[] randStrs = new String[10];
		for(int i=0; i<10; i++){
			randStrs[i] = randomString();
		}
		return randStrs;
	}
}
