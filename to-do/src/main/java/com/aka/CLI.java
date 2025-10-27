package com.aka;

import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class CLI implements UserInterface {
    private final TaskManager MANAGER;
    private  final Storage STORAGE;
    private final Scanner SCANNER = new Scanner(System.in);
    
    public CLI(TaskManager MANAGER, Storage STORAGE) {
        this.MANAGER = MANAGER;
        this.STORAGE = STORAGE;
    }
    
    @Override
    public void start() {
        loadTasks();
        while (true) { 
            printMainMenu();
            char mainMenuChoice = getUserInput("Choose an option: ").toLowerCase().charAt(0);
            switch (mainMenuChoice) {
                case '1' -> enterMainLoop();
                case '2' -> settings(); 
                case '3' -> {
                    SaveAndExit();
                    SCANNER.close();
                    return;
                }
                default -> System.out.println("Invalid option");
            }
            
        }
        
    }
    public void enterMainLoop() {
        while (true) {
            printActionMenu();
            char actionMenuChoice = getUserInput("Choose an option: ").toLowerCase().charAt(0);
            switch (actionMenuChoice) {
                case '5' -> showTasks();
                case '1' -> addTask();
                case '2' -> removeTask();
                case '3' -> markCompleted();
                case '4' -> {
                    return;
                }
                default -> System.out.println("Invalid option");
            }
            
        }
    }
    
    private void printMainMenu() {
        System.out.print("""
==============================
        TO-DO APPLICATION
==============================

1. Start
2. Settings
3. Exit

                """);
    }
    private void printActionMenu() {
        showTasks();
        System.out.println("\n1. Add new task | 2. Remove a task | 3. Mark as completed | 4. Back to main menu");
    }
    
    private String getUserInput(String message) {
        System.out.print(message);
        return SCANNER.nextLine();
    }
    
    private int getIndex(String userInput) {
        try {
            return Integer.parseInt(userInput)-1;
        }
        catch (NumberFormatException e) {
            System.out.println("Error:" + e);
            return 0;
        }

    }
    
    private void showTasks() {
        if (MANAGER.getTasks().isEmpty()) {
            System.out.println("There is no tasks yet.");
        }
        for (int i = 0; i < MANAGER.getTasks().size(); i++) {
            System.out.println((i + 1) + ". " + MANAGER.getTasks().get(i));
        }
    }
        
    private void addTask() {
        MANAGER.addTask(new Task(getUserInput("Enter title: ")));
        System.out.println("Task added!");
    }
    
    private void removeTask() {
        showTasks();
        int index = getIndex(getUserInput("Choose the task to remove: "));
        MANAGER.removeTask((MANAGER.getId(index)));
    }
    
    private void markCompleted() {
        showTasks();
        int index = getIndex(getUserInput("Choose the task to mark as completed: "));
        MANAGER.markCompleted(MANAGER.getId(index));
    }

    private void SaveAndExit() {
        try {
            STORAGE.saveTasks(MANAGER.getTasks());
            System.out.println("Saved succesfully! Goodbye!");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    
    private void loadTasks() {
        try {
            MANAGER.loadTasks(STORAGE.loadTasks());
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
        
    }
    
    private void settings() {

    }

}
