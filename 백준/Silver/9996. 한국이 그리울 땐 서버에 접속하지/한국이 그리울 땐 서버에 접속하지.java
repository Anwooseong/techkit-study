import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String pattern = scanner.nextLine();
        Queue<String> originalQueue = new LinkedList<>();

        int asteriskIndex = pattern.indexOf('*');
        originalQueue.add(pattern.substring(0, asteriskIndex));
        originalQueue.add(pattern.substring(asteriskIndex + 1));

        Queue<String> copiedQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            copiedQueue.addAll(originalQueue);
            String word = scanner.nextLine();

            String firstPattern = copiedQueue.poll();
            String secondPattern = copiedQueue.poll();

            int firstPatternIndex = word.indexOf(firstPattern);

            if (firstPatternIndex == -1) {
                System.out.println("NE");
                continue;
            }
            String secondWord = word.substring(firstPatternIndex + firstPattern.length());
            int secondPatternIndex = secondWord.lastIndexOf(secondPattern);
            if (secondPatternIndex == -1) {
                System.out.println("NE");
                continue;
            }
            if (firstPatternIndex == 0 && secondPatternIndex == secondWord.length() - secondPattern.length()) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
