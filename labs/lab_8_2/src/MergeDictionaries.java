import java.util.*;

public class MergeDictionaries {

    public static void main(String[] args) {
        Map<String, Integer> dict1 = new HashMap<>();
        dict1.put("a", 10);
        dict1.put("b", 20);
        dict1.put("c", 30);

        Map<String, Integer> dict2 = new HashMap<>();
        dict2.put("b", 5);
        dict2.put("c", 15);
        dict2.put("d", 25);

        Map<String, Integer> merged = mergeDicts(dict1, dict2);
        System.out.println(merged);
    }

    public static Map<String, Integer> mergeDicts(
            Map<String, Integer> dict1,
            Map<String, Integer> dict2) {

        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : dict1.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : dict2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (result.containsKey(key)) {
                result.put(key, result.get(key) + value);
            } else {
                result.put(key, value);
            }
        }

        return result;
    }
}
