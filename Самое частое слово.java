import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> freq = new HashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    freq.put(word, freq.getOrDefault(word, 0) + 1);
                }
            }
        }

        // Сортировка: сначала по убыванию частоты, затем лексикографически
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // по убыванию частоты
            } else {
                return a.getKey().compareTo(b.getKey()); // по алфавиту
            }
        });

        System.out.println(list.get(0).getKey());
    }
}
