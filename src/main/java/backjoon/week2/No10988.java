package backjoon.week2;

import java.util.Scanner;

public class No10988 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int answer = 1;
        for (int i = 0; i < word.length() / 2; i++) {
            char firstAlphabet = word.charAt(i);
            char secondAlphabet = word.charAt(word.length() - i - 1);
            if (firstAlphabet != secondAlphabet) {
                answer = 0;
                break;
            }
        }
        System.out.println(answer);
    }
}
