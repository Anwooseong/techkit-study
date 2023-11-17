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
import java.util.*;

class Solution {
    static int T, N;
    static List<List<Integer>> list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        

        for (int i = 1; i <= T; i++) {
            N = scanner.nextInt();
            list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    List<Integer> nums = new ArrayList<>();
                    nums.add(1);
                    list.add(nums);
                } else if (j == 1) {
                    List<Integer> nums = new ArrayList<>();
                    nums.add(1);
                    nums.add(1);
                    list.add(nums);
                } else {
                    List<Integer> integers = list.get(j - 1);
                    List<Integer> nums = new ArrayList<>();
                    nums.add(integers.get(0));
                    for (int k = 0; k < integers.size(); k++) {
                        if (k + 1 < integers.size()) {
                            int sum = integers.get(k) + integers.get(k + 1);
                            nums.add(sum);
                        }

                    }
                    nums.add(integers.get(integers.size() - 1));
                    list.add(nums);
                }
            }
            System.out.println("#"+i);
            for (List<Integer> integers : list) {
                for (Integer integer : integers) {
                    System.out.print(""+integer+" ");
                }
                System.out.println();
            }
        }
    }
}
