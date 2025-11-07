package com.example;

import java.util.Scanner;

public class App{

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String text = getUserInput("Введите текст: ");
        System.out.println("Общее количество символов: " + getLength(text));
        System.out.println("Количество слов: " + countWords(text));
        System.out.println("Самое длинное слово: " + getLongestWord(text));
        System.out.println("Количество предложений: " + countSentences(text));
    }

    private static String getUserInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
    
    private static int getLength(String text) {
        return text.length();
    }
    
    private static int countWords(String text) {
        return text.split("\\s+").length;
    }
    
    private static String getLongestWord(String text) {
        String[] words = text.split("\\s+");
        String longestWord = "";
    
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z0-9]", "");      
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
    
    private static String normalizeText(String text) {
        String[] sentences = text.split("(?<=[.!?])\\s*");
        StringBuilder normalizedText = new StringBuilder();
        
        for (String sentence : sentences) {
            if (!sentence.isEmpty()) {
                char firstChar = Character.toUpperCase(sentence.charAt(0));
                :
            }
        }
    }
}