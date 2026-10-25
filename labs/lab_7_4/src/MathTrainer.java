import java.util.*;

class MathProblem {
    private String question;
    private int answer;

    public MathProblem(String question, int answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }
}

public class MathTrainer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<MathProblem> problems = generateMathProblems("+", 3, 1, 20);
        testStudent(problems, scanner);

        problems = generateMathProblems("-", 3, 1, 20);
        testStudent(problems, scanner);

        problems = generateMathProblems("*", 3, 1, 10);
        testStudent(problems, scanner);

        scanner.close();
    }

    public static List<MathProblem> generateMathProblems(String operation, int count, int min, int max) {
        Random rand = new Random();
        List<MathProblem> problems = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int a = rand.nextInt(max - min + 1) + min;
            int b = rand.nextInt(max - min + 1) + min;
            int answer = 0;
            String question = "";

            switch (operation) {
                case "+":
                    answer = a + b;
                    question = a + " + " + b;
                    break;
                case "-":
                    answer = a - b;
                    question = a + " - " + b;
                    break;
                case "*":
                    answer = a * b;
                    question = a + " * " + b;
                    break;
            }
            problems.add(new MathProblem(question, answer));
        }
        return problems;
    }

    public static void testStudent(List<MathProblem> problems, Scanner scanner) {
        for (MathProblem problem : problems) {
            while (true) {
                System.out.print("Сколько будет " + problem.getQuestion() + "? ");
                String input = scanner.nextLine();
                try {
                    int userAnswer = Integer.parseInt(input);
                    if (userAnswer == problem.getAnswer()) {
                        System.out.println("Верно!");
                    } else {
                        System.out.println("Неверно! Правильный ответ: " + problem.getAnswer());
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка! Введите число.");
                }
            }
        }
    }
}