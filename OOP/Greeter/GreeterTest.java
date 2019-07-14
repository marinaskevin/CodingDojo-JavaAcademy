public class GreeterTest {
    public static void main(String[] args){
        Greeter.testGreeting("Kelvin");
        Greeter g = new Greeter();
        String greeting = g.greet();
        String greetingWithName = g.greet("Eduardo");
        if (greeting.equals("Hello World") || greetingWithName.equals("Greetings Eduardo, welcome to Coding Dojo!")){
            System.out.println("Test successful");
        } else{
            System.out.println("Test Fail");
        }
    }
}
