package com.aka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    private String saveFilePath;

    public FileHandler(String saveFilePath) {
        this.saveFilePath = saveFilePath;
    }

    public void saveFile(TaskManager taskManager,String saveFilePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(saveFilePath))) {
            for (String i : taskManager.getCsvFormattedHashMap()){
                    writer.write(i);
            }
        }
        catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void loadTasksFromFile(TaskManager taskManager,String saveFilePath) {
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(saveFilePath))) {
            String line;
            Task task;
            while ((line = reader.readLine()) != null) {
                String [] parts = line.split(",");
                if (parts.length == 3) {
                    task = new Task(parts[1], Boolean.parseBoolean(parts[2]));
                    taskManager.addExistingTask(Integer.parseInt(parts[0]), task);
                }
            }
        }
        catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
