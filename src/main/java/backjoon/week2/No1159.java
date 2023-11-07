package backjoon.week2;

import java.util.*;

public class No1159 {

    static Map<Character, Integer> map = new HashMap<>();
    static List<Character> answers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String name = scanner.nextLine();
            char alphabet = name.charAt(0);
            map.put(alphabet, map.getOrDefault(alphabet, 0) + 1);
            if (map.get(alphabet) == 5) {
                answers.add(alphabet);
            }
        }

        if (answers.isEmpty()) {
            System.out.println("PREDAJA");
        } else {
            answers.stream()
                    .sorted()
                    .forEach(System.out::print);
        }
    }
}
