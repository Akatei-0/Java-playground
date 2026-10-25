import java.util.*;

public class InvertDictionary {

    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("a", 1);
        original.put("b", 2);
        original.put("c", 1);

        Map<Integer, List<String>> inverted = invertDict(original);
        System.out.println(inverted);
    }

    public static <K, V> Map<V, List<K>> invertDict(Map<K, V> dict) {
        Map<V, List<K>> result = new HashMap<>();
    
        for (Map.Entry<K, V> entry : dict.entrySet()) {
            V key = entry.getValue();
    
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
    
            result.get(key).add(entry.getKey());
        }
    
        return result;
    }
}
