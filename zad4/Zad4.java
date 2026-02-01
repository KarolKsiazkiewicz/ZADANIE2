import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Zad4 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
            "ala", "ma", "kota", "kot", "ma", "ale", "kot", "ala", "ala"
        );

        List<String> result = words.stream()
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .map(e -> e.getKey() + "=" + e.getValue())
            .collect(Collectors.toList());

        System.out.println("Zadanie 4 - Wynik: " + result);
    }
}
