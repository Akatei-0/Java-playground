package com.example;

import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        String name = getFormattedUserInput("Введите имя: ");
        String familyName = getFormattedUserInput("Введите фамилию: ");
        String domainName = getFormattedUserInput("Введите домен: ");
        System.out.println("Сгенерированный email: " + generateEmail(name, familyName, domainName));
    }
    
    private static String getUserInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private static String getFormattedUserInput(String message) {
        String userInput = "";
        while (true) {
            userInput = getUserInput(message);
            if (userInput.isBlank()) {
                System.out.println("Ввод обязателен.");
                continue;
            }
            return userInput.toLowerCase().trim().replace(' ', '.');
            
        }
    }
    
    private static String generateEmail(String name, String familyName, String domainName) {
        return name + '.' + familyName + '@'+ domainName;
    }
}