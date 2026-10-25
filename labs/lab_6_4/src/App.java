import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите CSV-строку: ");
        String input = scanner.nextLine();

        processCsv(input);
    }

    public static void processCsv(String csv) {
        String[] fields = csv.split(",");

        if (fields.length != 4) {
            System.out.println("Ошибка: должно быть ровно 4 поля (имя, фамилия, возраст, email)");
            return;
        }

        String name = fields[0].trim();
        String surname = fields[1].trim();
        String ageStr = fields[2].trim();
        String email = fields[3].trim();

        if (name.isEmpty()) {
            System.out.println("Ошибка: имя не может быть пустым");
            return;
        }

        if (surname.isEmpty()) {
            System.out.println("Ошибка: фамилия не может быть пустой");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageStr);
            if (age <= 0) {
                System.out.println("Ошибка: возраст должен быть положительным числом");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: возраст должен быть числом");
            return;
        }

        if (!email.contains("@")) {
            System.out.println("Ошибка: некорректный email (нет символа '@')");
            return;
        }

        System.out.println("Данные пользователя:");
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + surname);
        System.out.println("Возраст: " + age);
        System.out.println("Email: " + email);
    }
}


