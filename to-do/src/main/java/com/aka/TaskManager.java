package com.aka;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
  private List<Task> tasks;

  public TaskManager() {
    tasks = new ArrayList<>();
  }
  
  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks){
     this.tasks = tasks; 
  }
  
  public Task getTaskByID(UUID id) {
    for (int i = 0; i < tasks.size(); i++) {
      if (id.equals(tasks.get(i).getId())) {
        return tasks.get(i);
      }
    }
    return null;
  }
  
  
   public void addTask(Task task) {
    tasks.add(task);
  }

  public void removeTask(UUID id) {
    for (int i = 0; i < tasks.size(); i++) {
      if (id.equals(tasks.get(i).getId())) {
        tasks.remove(i);
        return;
      }
    }
  }

  public void editTask(UUID id, String newTitle, String newDescription) {
    for (int i = 0; i < tasks.size(); i++) {
      if (id.equals(tasks.get(i).getId())) {
        Task task = tasks.get(i);
        if (!(newTitle.equals(task.getTitle()))) {task.setTitle(newTitle);}
        // if (!(newDescription.equals(task.getDescription()))) {task.setDescription(newDescription);}

      }
    }
  }


  public void markCompleted(UUID id) {
    for (int i = 0; i < tasks.size(); i++) {
      if (id.equals(tasks.get(i).getId())) {
        tasks.get(i).setDone();
        return;
      }
    }
  }
  

  public UUID getId(int index) {
    Task selectedTask = tasks.get(index);
    UUID selectedUUID = selectedTask.getId();
    return selectedUUID;
  }
  
}
