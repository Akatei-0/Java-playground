package com.aka;

import java.util.Scanner;

public class Main {
  /**
   * @param args
   */
  public static void main(String[] args) {
    
    final String SAVEFILEPATH = "/home/aka/Projects/to-do/saves/task-save.csv";

    TaskManager taskManager = new TaskManager();
    
    FileHandler fileHandler = new FileHandler(SAVEFILEPATH);
    
    fileHandler.loadTasksFromFile(taskManager, SAVEFILEPATH);

    Scanner scanner = new Scanner(System.in);

    Task task;
    boolean run = true;
    boolean isDone = false;
    String title = "";
    int id = 0;

    while (run) {
      System.out.println("Enter your action (s : show | a: add | r : remove | e: edit | m: mark | q : quit):");
      char action = scanner.next().toLowerCase().charAt(0);

      switch (action) {
        case 'q':
          System.out.println("Bye!");
          run = false;
          break;

        case 's':
          System.out.println("Tasks:");
          taskManager.displayTasks();
          break;

        case 'a':
/*           System.out.print("Enter task id: ");
          id = scanner.nextInt() */;
          scanner.nextLine();

          System.out.print("Enter task title: ");
          title = scanner.nextLine();
          isDone = false;

          task = new Task(title, isDone);

          taskManager.addTask(task);
          System.out.println("Task added!");
          break;

        case 'r':
          System.out.print("Enter task id: ");
          id = scanner.nextInt();
          taskManager.removeTask(id);
          System.out.println("Task " + id + " removed!");
          break;

        case 'e':
          System.out.print("Enter task id: ");
          id = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Enter task title: ");
          title = scanner.nextLine();
          isDone = false;

          task = new Task(title, isDone);

          taskManager.editTask(id, task);
          break;

        case 'm':
          System.out.print("Enter task id: ");
          id = scanner.nextInt();
          

        default:
          System.out.println("input a valid action");
      }
    }
    System.out.println("Saving file...");
    fileHandler.saveFile(taskManager, SAVEFILEPATH);
    scanner.close();

  }
}
