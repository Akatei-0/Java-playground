package com.aka;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class TaskManager {
  private HashMap<Integer, Task> tasks;
  private int nextId = 0;

  public TaskManager() {
    tasks = new HashMap<>();
  }
  
  public HashMap<Integer, Task> getHashMap() {
    return tasks;
  }

  public ArrayList<String> getCsvFormattedHashMap() {
    ArrayList<String> csvFormattedData = new ArrayList<>(); 
    for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
      csvFormattedData.add(entry.getKey() + "," + entry.getValue().toCsv() + "\n");
    }
    return csvFormattedData;
  }

  public void recieveTasksFromAFile(String saveFilePath){
    
  }
  
  public void addTask(Task task) {
    tasks.put(nextId++, task);
  }

  public void addExistingTask(int id, Task task) {
    tasks.put(id, task);
  }
  
  public void setCurrentId(int id) {
    nextId =  id;
  }


  public void removeTask(int taskId) {
    tasks.remove(taskId);
  }

  public void editTask(int id, Task task) {
    tasks.replace(id, task);
  }

  public void displayTasks() {
    for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue().toString());
    }
  }
}
