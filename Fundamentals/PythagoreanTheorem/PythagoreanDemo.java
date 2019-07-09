public class PythagoreanDemo {
	public static void main(String[] args){
		int legA = 3;
		int legB = 4;
		Pythagorean pytha = new Pythagorean();
		System.out.println("The legs are "+legA+" and "+legB+" units long.");
		System.out.println("Therefore, the hypotenuse is "+pytha.calculateHypotenuse(legA,legB)+" units long.");
	}
}
