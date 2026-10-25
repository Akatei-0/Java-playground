import java.util.*;

public class WordFrequency {

    public static void main(String[] args) {
        String text = "Hello world! Hello Python. Python is great, isn't it?";
        Map<String, Integer> result = wordFrequency(text);
        System.out.println(result);
    }

    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> freq = new HashMap<>();

        String cleaned = text.toLowerCase().replaceAll("[.,!?;:]", "");

        String[] words = cleaned.split("\\s+");

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(freq.entrySet());

        entries.sort((a, b) -> b.getValue() - a.getValue());

        Map<String, Integer> sorted = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            sorted.put(entry.getKey(), entry.getValue());
        }

        return sorted;
    }
}