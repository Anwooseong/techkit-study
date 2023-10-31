package backjoon.week1;

import java.util.Scanner;
import java.util.Stack;

public class No9935 {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String bomb = sc.nextLine();
        char lastChar = bomb.charAt(bomb.length() - 1);
        Stack<Character> stack = new Stack<>();



        for (int i = 0; i < sentence.length(); i++) {
            stack.push(sentence.charAt(i));
            if (stack.size() >= bomb.length() && stack.peek() == lastChar) {
                int charIndex = bomb.length()-1;
                boolean includeBomb = true;
                for (int j = stack.size() - 1; j >= stack.size() - bomb.length(); j--) {

                    //마지막 글자부터 폭탄 문자열의 사이즈를 빼서 폭탄 문자열의 처음까지 비교
                    if (stack.get(j) != bomb.charAt(charIndex)) {
                        includeBomb = false;
                        break;
                    }
                    charIndex--;
                }
                if (includeBomb) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder answer = new StringBuilder();

            for (Character character : stack) {
                answer.append(character);
            }
            System.out.println(answer);
        }
    }
}
