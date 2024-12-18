import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 커피의 개수
        int K = Integer.parseInt(st.nextToken()); // 목표 카페인 양

        int[] coffees = new int[N + 1];
        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            coffees[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0 카페인을 얻기 위한 잔 수는 0

        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= coffees[i]; j--) {
                if (dp[j - coffees[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coffees[i]] + 1);
                }
            }
        }

        // K 카페인을 만들 수 없는 경우
        if (dp[K] == Integer.MAX_VALUE) {
            System.out.println(-1); // K 카페인을 만들 수 없는 경우
        } else {
            System.out.println(dp[K]); // K 카페인을 만들기 위한 최소 잔 수
        }
    }
}
