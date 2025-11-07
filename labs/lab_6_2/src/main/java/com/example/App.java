package com.example;

import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {
        String password = getUserInput("Введите пароль: ");
        printTestResult((password.length() > 7), "Длина не менее 8 символов:");
        printTestResult(containsPattern(password, StringPattern.CONTAINS_NUMBERS), "Содержит цифру:");
        printTestResult(containsPattern(password, StringPattern.CONTAINS_UPPERCASE), "Содержит заглавную букву:");
        printTestResult(containsPattern(password, StringPattern.CONTAINS_SPECIAL_CHARACTERS), "Содержит специальный символ:");
        System.out.printf("%s %s%n", "Пароль надежен: ", (isSafe(password) ? "True" : "False"));
        scanner.close();
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
