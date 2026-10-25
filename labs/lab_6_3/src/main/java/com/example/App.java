package com.example;

import java.util.Scanner;

public class App{

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String text = getUserInput("Введите текст: ");
        System.out.println("Результаты анализа:");
        System.out.println("Общее количество символов: " + getLength(text));
        System.out.println("Количество слов: " + countWords(text));
        System.out.println("Самое длинное слово: " + getLongestWord(text));
        System.out.println("Количество предложений: " + countSentences(text));
        System.out.println("Нормализованный текст: " + normalizeText(text));
    }

    private static String getUserInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
    
    private static int getLength(String text) {
        int count = 0;

        for (char c : text.toCharArray()) {
            if (c != ' ') {
                count++;
            }
        }
        return count;
    }
    
    private static int countWords(String text) {
        return text.split("\\s+").length;
    }
    
    private static String getLongestWord(String text) {
        String[] words = text.split("[^а-яА-Яa-zA-Z]+");
        String longestWord = "";
    
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
    
    private static int countSymbol(String str, char symbol) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == symbol) {
                count++;
            }
        }
    return count;
    }
    
    private static int countSentences(String text) {
        return countSymbol(text, '.') + countSymbol(text, '!') + countSymbol(text, '?');
    }
    
    public static String normalizeText(String text) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (capitalizeNext && Character.isLetter(c)) {
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                result.append(c);
            }

            if (c == '.' || c == '!' || c == '?') {
                capitalizeNext = true;
            }
        }

        return result.toString();
    }
}
