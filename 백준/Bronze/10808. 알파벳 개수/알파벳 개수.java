import java.util.*;

public class Main {

    static Map<Character, Integer> alphabetMap = new HashMap<>();
    static String word;
    static char[] alphabetArray;
    static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        word = scanner.nextLine();
        alphabetArray = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            alphabetArray[i] = word.charAt(i);
        }

        for (char c : alphabetArray) {
            alphabetMap.put(c, alphabetMap.getOrDefault(c, 0) + 1);
        }

        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
            if (alphabetMap.containsKey((char)i)) {
                System.out.print("" + alphabetMap.get((char)i) + " ");
            } else {
                System.out.print("0 ");
            }
        }

    }
}
