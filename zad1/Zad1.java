import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Zad1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(15, 8, 23, 4, 42, 16, 11, 30, 7, 19, 2, 35, 28, 13, 6);

        List<Integer> result = numbers.stream()         
                .filter(n -> n % 2 == 0)                    
                .sorted()                                   
                .collect(Collectors.toList());              

        System.out.println("Zadanie 1 - Wynik: " + result);
    }
}
