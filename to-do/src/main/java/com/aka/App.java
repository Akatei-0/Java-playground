package com.aka;

public class App {
    public static void main (String[] args) {
        TaskManager manager = new TaskManager();
        Storage storage = new FileStorage("/home/aka/Projects/Java-playground/to-do/saves/task.json");
        UserInterface ui = new CLI(manager, storage);
        ui.start();
    }
}