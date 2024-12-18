import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(bf.readLine());
            int[] coins = new int[N + 1];
            st = new StringTokenizer(bf.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(bf.readLine());
            int[] dp = new int[M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (j - coins[i] > 0) {
                        dp[j] = dp[j] + dp[j - coins[i]];
                    } else if (j - coins[i] == 0) {
                        dp[j]++;
                    }
                }
            }
            System.out.println(dp[M]);
        }
    }
}