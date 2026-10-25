import java.util.*;

public class App {

    public static void main(String[] args) {
        try {
            List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
            Map<String, Double> stats = calculateStatistics(numbers);
            System.out.println(stats);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static Map<String, Double> calculateStatistics(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список чисел не может быть пустым.");
        }

        double min = Collections.min(numbers);
        double max = Collections.max(numbers);
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        double average = sum / numbers.size();
        double count = numbers.size();

        Map<String, Double> stats = new HashMap<>();
        stats.put("min", min);
        stats.put("max", max);
        stats.put("sum", sum);
        stats.put("average", average);
        stats.put("count", count);

        return stats;
    }
}