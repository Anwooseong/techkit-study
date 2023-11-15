package backjoon.week3;

import java.util.Scanner;

public class No4659 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String gather = "aeiou";

        while (!word.equals("end")) {
            int repeatSum = 1;
            char prevAlphabet = 'ㄱ';
            boolean isSuccess = false;
            for (int i = 0; i < word.length(); i++) {
                char alphabet = word.charAt(i);
                if (!isSuccess) {
                    if (gather.contains(String.valueOf(alphabet))) {
                        isSuccess = true;
                    }
                }
                if (gather.contains(String.valueOf(alphabet)) && gather.contains(String.valueOf(prevAlphabet))) {
                    repeatSum++;
                    if (repeatSum == 3) {
                        //허용 x
                        isSuccess = false;
                        break;
                    }
                } else if (!gather.contains(String.valueOf(alphabet)) && !gather.contains(String.valueOf(prevAlphabet))) {
                    repeatSum++;
                    if (repeatSum == 3) {
                        //허용 x
                        isSuccess = false;
                        break;
                    }
                } else {
                    isSuccess = true;
                    repeatSum = 1;
                }
                if (repeatSum == 1 && prevAlphabet == alphabet) {
                    if (alphabet == 'e' || alphabet == 'o') {
                        //허용
                        repeatSum++;
                        isSuccess = true;
                    } else {
                        //허용 x
                        isSuccess = false;
                        break;
                    }
                }
                prevAlphabet = alphabet;
            }
            if (isSuccess) {
                System.out.println("<" + word + "> is acceptable.");
            } else {
                System.out.println("<" + word + "> is not acceptable.");
            }
            word = scanner.nextLine();


        }
    }
}
