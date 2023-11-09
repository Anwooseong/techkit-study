import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

//        boolean isEven = word.length() % 2 == 0;
        int answer = 1;

        for (int i = 0; i < word.length() / 2; i++) {
            char firstAlphabet = word.charAt(i);
            char secondAlphabet = word.charAt(word.length() - i - 1);
            if (firstAlphabet != secondAlphabet) {
                answer = 0;
                break;
            }
        }
//        if (isEven) {
//            for (int i = 0; i < word.length() / 2 - 1; i++) {
//                char firstAlphabet = word.charAt(i);
//                char secondAlphabet = word.charAt(word.length() - i - 1);
//                if (firstAlphabet != secondAlphabet) {
//                    answer = 0;
//                    break;
//                }
//            }
//        } else {
//
//        }
        System.out.println(answer);
    }
}
