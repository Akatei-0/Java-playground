package com.aka;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
                // case '1' -> viewTask();
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
        // System.out.println("\n|1. View task.|2. Add new task.|3. Remove a task.|4. Mark as completed.|5. Back to main menu.|");
        System.out.println("\n|1. Add new task.|2. Remove a task.|3. Mark as completed.|4. Back to main menu.|");
    }
    
    private String getUserInput(String message) {
        System.out.print(message);
        return SCANNER.nextLine();
    }
    
    private int getIndex(String message) {
        int userInput;
        String invalidIndexMessage = "Invalid index.";
        while (true) {
            try {
                userInput = Integer.parseInt(getUserInput(message));

                if (userInput <= MANAGER.getTasks().size() && userInput> 0) {
                    return userInput-1;
                }
                else {
                    System.out.println(invalidIndexMessage);
                }
            }
            catch (NumberFormatException e) {
                System.out.println(invalidIndexMessage);
            }
        }
    }
    
    private Priority getUserPriority(String message) {
        Priority priority = Priority.LOW;
        String userInput;
        while (true) {
            try {
                userInput = getUserInput(message).trim().toUpperCase();
                if (userInput.isBlank()) {return priority;}

                priority = Priority.valueOf(userInput);
                return priority;
                
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid priority! Try again!");
            }
        }
    }
    
    // private LocalDateTime getUserDateTime(String message) {
    //     String timeInput;
    //     String dateInput;
    //     while (true) {
    //         try {

    //             dueDateTime = LocalDate
                
    //         } catch (Exception e) {
    //         }
    //     }
    // }

    
    private void showTasks() {
        if (MANAGER.getTasks().isEmpty()) {
            System.out.println("There is no tasks yet.");
        }
        for (int i = 0; i < MANAGER.getTasks().size(); i++) {
            System.out.println((i + 1) + ". " + MANAGER.getTasks().get(i));
        }
    }
    
    private void viewTask() {
        showTasks();
        int index = getIndex("Choose the task to view: ");
        if (MANAGER.getTaskByID(MANAGER.getId(index)) != null) {
            System.out.println(MANAGER.getTaskByID(MANAGER.getId(index)));
        }
        else {
            System.out.println("Task not found");
        }
        
    }
        
    private void addTask() {
        String title = getUserInput("Enter title: ");
        // String category = getUserInput("(optional) Enter category: ");
        // String description = getUserInput("(optional) Enter description: ");
        Priority priority = getUserPriority("(LOW, MEDIUM, HIGH, CRITICAL) (default: LOW) Enter priority: ");

        
        MANAGER.addTask(new Task(title, priority));
        System.out.println("Task added!");
    }
    
    private void removeTask() {
        showTasks();
        int index = getIndex("Choose the task to remove: ");
        MANAGER.removeTask((MANAGER.getId(index)));
    }
    
    private void markCompleted() {
        showTasks();
        int index = getIndex("Choose the task to mark as completed: ");
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
            MANAGER.setTasks(STORAGE.loadTasks());
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
        
    }
    
    private void settings() {

    }
    
    private void SortTasks(SortBy sortBy){
        List tasks = MANAGER.getTasks();
        List sortedTasks;
        switch (sortBy) {
            case TITLE -> {
                MANAGER.setTasks(sortedTasks);
            }
            case CREATION_TIME -> {}
            case PRIORITY -> {}
            case DONE -> {}
        }
    }

}
