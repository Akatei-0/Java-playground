import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private final SequenceGenerator generator = new SequenceGenerator();

    public void run (){
        generator.generateSequence(getUserInputInt("start"), getUserInputInt("end"), getUserInputInt("step"));
        scanner.close();
    }
    private int getUserInputInt(String message) {
        System.out.print(message + ": ");
        int userInput = Integer.parseInt(scanner.nextLine());
        return userInput;
    }
}
