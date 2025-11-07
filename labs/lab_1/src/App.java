import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private final TextAnalyzer analyzer = new TextAnalyzer();
    

    public void run() {
        analyzer.analyzeText(getUserInput());
    }
    public String getUserInput() {
        System.out.print("Enter your input: ");
        String userInput = scanner.nextLine();
        scanner.close();
        return userInput;
    }
}
