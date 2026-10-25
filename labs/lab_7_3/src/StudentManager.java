import java.util.*;

class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}

public class StudentManager {

    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Найти лучшего студента");
            System.out.println("4. Посчитать среднюю оценку");
            System.out.println("5. Выйти");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addStudentMenu();
                case "2" -> removeStudentMenu();
                case "3" -> findTopStudentMenu();
                case "4" -> printAverageGrade();
                case "5" -> running = false;
                default -> System.out.println("Некорректный выбор.");
            }
        }
        scanner.close();
    }

    private static void addStudentMenu() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите оценку: ");
        int grade = Integer.parseInt(scanner.nextLine());
        students.add(new Student(name, grade));
        System.out.println("Студент добавлен!");
    }

    private static void removeStudentMenu() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        if (removeStudent(name)) {
            System.out.println("Студент удалён!");
        } else {
            System.out.println("Студент не найден!");
        }
    }

    private static boolean removeStudent(String name) {
        return students.removeIf(s -> s.getName().equals(name));
    }

    private static void findTopStudentMenu() {
        Student top = findTopStudent();
        if (top != null) {
            System.out.println("Лучший студент: " + top.getName() + " с оценкой " + top.getGrade());
        } else {
            System.out.println("Список студентов пуст.");
        }
    }

    private static Student findTopStudent() {
        if (students.isEmpty()) return null;
        Student top = students.get(0);
        for (Student s : students) {
            if (s.getGrade() > top.getGrade()) {
                top = s;
            }
        }
        return top;
    }

    private static void printAverageGrade() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }
        double sum = 0;
        for (Student s : students) {
            sum += s.getGrade();
        }
        System.out.println("Средняя оценка: " + (sum / students.size()));
    }
}