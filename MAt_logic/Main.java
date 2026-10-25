

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Программа нахождения СКНФ ===");
        System.out.println();
        System.out.println("Расшифровка обозначений:");
        System.out.println("СКНФ — совершенная конъюнктивная нормальная форма");
        System.out.println("x1, x2, x3... — булевы переменные");
        System.out.println("!  — отрицание (НЕ)");
        System.out.println("&  — конъюнкция (И)");
        System.out.println("|  — дизъюнкция (ИЛИ)");
        System.out.println("0  — ложь");
        System.out.println("1  — истина");
        System.out.println();
        System.out.println("Введите значения функции для всех наборов.");
        System.out.println("Наборы вводятся в порядке от 0 до 2^n - 1.");
        System.out.println();

        System.out.print("Введите количество переменных: ");
        int n = sc.nextInt();

        if (n < 1 || n > 20) {
            System.out.println("Ошибка: количество переменных должно быть от 1 до 20.");
            sc.close();
            return;
        }

        int rows = 1 << n;
        int[] f = new int[rows];

        System.out.println("Введите значения функции (0 или 1):");

        for (int i = 0; i < rows; i++) {
            System.out.print("Набор " + i + ": ");
            f[i] = sc.nextInt();

            if (f[i] != 0 && f[i] != 1) {
                System.out.println("Ошибка: можно вводить только 0 или 1.");
                sc.close();
                return;
            }
        }

        StringBuilder sknf = new StringBuilder();
        boolean first = true;

        for (int i = 0; i < rows; i++) {
            if (f[i] == 0) {
                if (!first) {
                    sknf.append(" & ");
                }

                sknf.append("(");

                for (int j = 0; j < n; j++) {
                    if (j > 0) {
                        sknf.append(" | ");
                    }

                    int bit = (i >> (n - 1 - j)) & 1;

                    if (bit == 1) {
                        sknf.append("!");
                    }

                    sknf.append("x").append(j + 1);
                }

                sknf.append(")");
                first = false;
            }
        }

        System.out.println();
        System.out.println("=== Результат ===");

        if (first) {
            System.out.println("Функция тождественно равна 1.");
            System.out.println("СКНФ в расширенном представлении: 1");
        } else {
            System.out.println("СКНФ: " + sknf);
        }

        System.out.println();
        System.out.println("Расшифровка результата:");
        System.out.println("!x1 означает НЕ x1.");
        System.out.println("x1 | x2 означает x1 ИЛИ x2.");
        System.out.println("(x1 | x2) & (x3 | !x4)");
        System.out.println("означает (x1 ИЛИ x2) И (x3 ИЛИ НЕ x4).");
        System.out.println();
        System.out.println("Правило построения СКНФ:");
        System.out.println("1. Выбираются наборы, на которых функция равна 0.");
        System.out.println("2. Если переменная равна 0, записываем её без !.");
        System.out.println("3. Если переменная равна 1, записываем её с !.");
        System.out.println("4. В скобках ставится ИЛИ, между скобками — И.");

        sc.close();
    }
}