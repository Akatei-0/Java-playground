package com.aka;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
  private UUID id;
  // private String category;
  private String title;
  // private String description;
  private Priority priority;
  // private LocalDateTime dueDateTime;
  // private LocalDateTime dateTimeCreated;
  private boolean done;

  // public Task(String title, String category, String description, Priority priority, LocalDateTime dueDateTime, boolean done) {
  public Task(String title, Priority priority){
    this.id = UUID.randomUUID();
    // this.dateTimeCreated = LocalDateTime.now();
    // this.category = category;
    this.title = title;
    // this.description = description;
    this.priority = priority;
    // this.dueDateTime = dueDateTime;
    this.done = false;
  }
  // public Task(UUID id, LocalDateTime dateTimeCreated, String title, String category, String description, Priority priority, LocalDateTime dueDateTime, boolean done) {
  public Task(UUID id, String title, Priority priority, boolean done) {
    this.id = id;
    // this.dateTimeCreated = dateTimeCreated;
    // this.category = category;
    this.title = title;
    // this.description = description;
    this.priority = priority;
    // this.dueDateTime = dueDateTime;
    this.done = done;
  }


  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }

  // public LocalDateTime getDateTimeCreated() {
  //   return dateTimeCreated;

  // }

  // public String getCategory() {
  //   return category;
  // }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  // public String getDescription() {
  //   return description;
  // }

  public Priority getPriority() {
    return priority;
  }
  
  public void setPriority(Priority priority) {
    this.priority = priority;
  }
  
  // public LocalDateTime getDueDateTime() {
  //   return dueDateTime;
  // }

  public boolean getDone() {
    return done;
  }

  public void setDone() {
    this.done = !this.done;
  }

  // public void setCategory(String category) {
  //   this.category = category;
  // }

  
  // public void setDescription(String description) {
  //   this.description = description;
  // }

  
  @Override
  public String toString() {
    // return ((done ? "[x]" : "[ ]") + " " + title + " | priority: " + priority + String.format("%" + width + "s", dueDateTime));
    // return String.format("[%s] [%s] %s %10s", done ? "x" : " ", priority, title, dueDateTime);
    return String.format("[%s] [%s] %s", done ? "x" : " ", priority, title);
    // return String.format("[%s] %s %10s", done ? "x" : " ", title, id);
  }
}
