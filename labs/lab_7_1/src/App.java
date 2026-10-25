import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {
        String password = getUserInput("Введите пароль: ");
        System.out.println(isValidPassword(password));
        scanner.close();
    }
    
    private static boolean isValidPassword(String password) {
        if (!(password.length()>8)) {return false;}
        if (!(containsPattern(password, StringPattern.CONTAINS_NUMBERS))) {return false;}
        if (!(containsPattern(password, StringPattern.CONTAINS_UPPERCASE))) {return false;}
        if (!(containsPattern(password, StringPattern.CONTAINS_SPECIAL_CHARACTERS))) {return false;}
        return true;
    }
    
    private static String getUserInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
    
    private static void printTestResult(boolean isTestPassed, String message) {
        System.out.printf(" - %s %s%n", message, (isTestPassed) ? "✓" : "✗");
    }
    
    private static boolean containsPattern(String str, StringPattern pattern) {
        return str.matches(pattern.getPattern());
    }
    
    private static boolean isSafe (String password) {
        if (!(password.length() > 7)) {return false;}
        if (!containsPattern(password, StringPattern.CONTAINS_NUMBERS)) {return false;}
        if (!containsPattern(password, StringPattern.CONTAINS_UPPERCASE)) {return false;}
        if (!containsPattern(password, StringPattern.CONTAINS_SPECIAL_CHARACTERS)) {return false;}
        return true;
    }
    
}
