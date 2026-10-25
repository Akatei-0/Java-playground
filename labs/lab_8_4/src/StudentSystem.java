import java.util.*;

class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentSystem {

    private static Map<Integer, Student> db = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Найти студента");
            System.out.println("4. Обновить оценку");
            System.out.println("5. Показать лучших студентов");
            System.out.println("6. Выйти");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addStudentMenu();
                case "2" -> removeStudentMenu();
                case "3" -> findStudentMenu();
                case "4" -> updateGradeMenu();
                case "5" -> topStudentsMenu();
                case "6" -> running = false;
                default -> System.out.println("Неверный ввод");
            }
        }
    }

    static void addStudent(int id, String name, int grade) {
        db.put(id, new Student(name, grade));
    }

    static void removeStudent(int id) {
        db.remove(id);
    }

    static Student findStudent(int id) {
        return db.get(id);
    }

    static void updateGrade(int id, int newGrade) {
        if (db.containsKey(id)) {
            db.get(id).grade = newGrade;
        }
    }

    static List<Map.Entry<Integer, Student>> getTopStudents(int n) {
        List<Map.Entry<Integer, Student>> list = new ArrayList<>(db.entrySet());
        list.sort((a, b) -> b.getValue().grade - a.getValue().grade);
        return list.subList(0, Math.min(n, list.size()));
    }

    static void addStudentMenu() {
        Integer id = readInt("ID: ");
        if (id == null) return;

        System.out.print("Имя: ");
        String name = scanner.nextLine();

        Integer grade = readInt("Оценка: ");
        if (grade == null) return;

        addStudent(id, name, grade);
        System.out.println("Студент добавлен");
    }

    static void removeStudentMenu() {
        Integer id = readInt("ID: ");
        if (id == null) return;

        if (db.containsKey(id)) {
            removeStudent(id);
            System.out.println("Студент удалён");
        } else {
            System.out.println("Студент не найден");
        }
    }

    static void findStudentMenu() {
        Integer id = readInt("ID: ");
        if (id == null) return;

        Student s = findStudent(id);
        if (s != null) {
            System.out.println("Имя: " + s.name + ", Оценка: " + s.grade);
        } else {
            System.out.println("Студент не найден");
        }
    }

    static void updateGradeMenu() {
        Integer id = readInt("ID: ");
        if (id == null) return;

        Integer grade = readInt("Новая оценка: ");
        if (grade == null) return;

        if (db.containsKey(id)) {
            updateGrade(id, grade);
            System.out.println("Оценка обновлена");
        } else {
            System.out.println("Студент не найден");
        }
    }

    static void topStudentsMenu() {
        Integer n = readInt("Сколько студентов показать: ");
        if (n == null) return;

        for (var entry : getTopStudents(n)) {
            System.out.println(entry.getKey() + ": " +
                    entry.getValue().name + " (" +
                    entry.getValue().grade + ")");
        }
    }

    static Integer readInt(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите число");
            return null;
        }
    }
}