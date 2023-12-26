package backjoon.week7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No2776 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < T; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int N = sc.nextInt();
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                map.put(num, 0);
            }

            int M = sc.nextInt();
            for (int j = 0; j < M; j++) {
                int num = sc.nextInt();
                int answer = map.containsKey(num) ? 1 : 0;
                result.append(answer).append("\n");
            }
        }

        System.out.print(result);
    }
}

