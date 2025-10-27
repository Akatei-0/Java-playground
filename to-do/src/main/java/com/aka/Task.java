package com.aka;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
  private UUID id;
  // private String category;
  private String title;
  // private String description;
  // private int priority;
  // private LocalDateTime dueDateTime;
  // private LocalDateTime dateTimeCreated;
  private boolean done;

  // public Task(int id, LocalDateTime dateTimeCreated,String category, String
  // title, String description, int priority, LocalDateTime dueDateTime, boolean
  // done) {
  public Task(String title) {
    this.id = UUID.randomUUID();
    // this.dateTimeCreated = dateTimeCreated;
    // this.category = category;
    this.title = title;
    // this.description = description;
    // this.priority = priority;
    // this.dueDateTime = dueDateTime;
    this.done = false;
  }
  public Task(UUID id, String title, boolean done) {
    this.id = id;
    this.title = title;
    this.done = done;
  }

/*   public int getId() {
    return id;
  } */

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

  // public String getDescription() {
  //   return description;
  // }

  // public int getPriority() {
  //   return priority;
  // }

  // public LocalDateTime getDueDateTime() {
  //   return dueDateTime;
  // }

  public boolean getDone() {
    return done;
  }

  // public void setCategory(String category) {
  //   this.category = category;
  // }

  public void setTitle(String title) {
    this.title = title;
  }
  
  // public void setDescription(String description) {
  //   this.description = description;
  // }

  public void setDone() {
    this.done = !this.done;
  }
  
  @Override
  public String toString() {
    return ((done ? "[x]" : "[ ]") + " " + title);
  }
}
