/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

class Solution {

    static int T;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= T; i++) {
            String line = scanner.nextLine();
            char firstAlphabet = line.charAt(0);
            StringBuilder sb = new StringBuilder();
            sb.append(firstAlphabet);

            for (int j = 1; j < line.length(); j++) {
                if (firstAlphabet == line.charAt(j)) {
                    //이때 생각
                    StringBuilder secondWord = new StringBuilder();
//                    System.out.println("sb.length() = " + sb.length());
                    for (int k = j; k < j + sb.length(); k++) {
                        if (k >= line.length()) {
                            break;
                        }
                        secondWord.append(line.charAt(k));
                    }
//                    System.out.println("secondWord = " + secondWord);
                    if (sb.toString().equals(secondWord.toString())) {
//                        System.out.println(sb.length());
                        j += sb.length() - 2;
                        break;
                    }else{
                        sb.append(line.charAt(j));
                    }
                } else {
                    sb.append(line.charAt(j));
//                    System.out.println("sb = " + sb);
                }
            }

            System.out.println("#" + i + " " + sb.length());
        }
    }
}