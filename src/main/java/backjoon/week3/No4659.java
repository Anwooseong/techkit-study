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
                //최소 모음 하나
                if (!isSuccess) {
                    if (gather.contains(String.valueOf(alphabet))) {
                        isSuccess = true;
                    }
                }
                //같은 글자 2번 연속 x, ee와 oo 허용
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
                //모음이 3개 연속으로 올때
                else if (gather.contains(String.valueOf(alphabet)) && gather.contains(String.valueOf(prevAlphabet))) {
                    repeatSum++;
                    if (repeatSum == 3) {
                        //허용 x
                        isSuccess = false;
                        break;
                    }
                }
                //자음이 3개 연속으로 올때
                else if (!gather.contains(String.valueOf(alphabet)) && !gather.contains(String.valueOf(prevAlphabet))) {
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
