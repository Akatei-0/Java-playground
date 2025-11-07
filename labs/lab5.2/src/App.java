
import java.util.Scanner;


public class App {
    private final Scanner scanner = new Scanner(System.in);
    private boolean run = true;
    private int integersCounter = 0;
    private int floatsCounter = 0;
    private int linesCounter = 0;

    public void run() {
        
        while (run) {
            String userInput = getUserInput("Введите строку (Enter для завершения): "); 
            if (userInput == "") {break;}
            else if (isDigit(userInput)) {integersCounter++;}
            else if (isFloat(userInput)) {floatsCounter++;}
            else {linesCounter++;}
        }
        printText("Результаты анализа: \n");
        printText("Целых чисел: " + integersCounter + "\n");
        printText("Дробных чисел: " + floatsCounter + "\n");
        printText("Строк: " + linesCounter + "\n");

    }
    private String getUserInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    } 
    
    private void printText(String text) {
        System.out.print(text);
    }
    
    private boolean isDigit(String userInput) {
        try {
            if (Integer.parseInt(userInput) > 0) {return true;} 
            else {return false;}
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean isFloat(String userInput) {
        try {
            if (Float.parseFloat(userInput) > 0) {return true;} 
            else {return false;}
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
