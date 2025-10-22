package com.aka;

import java.time.LocalDateTime;

public class Task {
  private String category;
  private String title;
  private String description;
  private int priority;
  private LocalDateTime dueDateTime;
  private LocalDateTime dateTimeCreated;
  private boolean isDone;

  // public Task(int id, LocalDateTime dateTimeCreated,String category, String
  // title, String description, int priority, LocalDateTime dueDateTime, boolean
  // isDone) {
  public Task(String title, boolean isDone) {
    // this.id = id;
    // this.dateTimeCreated = dateTimeCreated;
    // this.category = category;
    this.title = title;
    // this.description = description;
    // this.priority = priority;
    // this.dueDateTime = dueDateTime;
    this.isDone = isDone;
  }

/*   public int getId() {
    return id;
  } */

  public LocalDateTime getDateTimeCreated() {
    return dateTimeCreated;

  }

  public String getCategory() {
    return category;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public int getPriority() {
    return priority;
  }

  public LocalDateTime getDuDateTime() {
    return dueDateTime;
  }

  public boolean getIsDone() {
    return isDone;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void markDone() {
    this.isDone = !this.isDone;
  }
  
  public String toCsv() {
    return title + "," + isDone;
  }

  @Override
  public String toString() {
    return title + " done:" + ((isDone) ? "✅" : "❌");
  }
}
