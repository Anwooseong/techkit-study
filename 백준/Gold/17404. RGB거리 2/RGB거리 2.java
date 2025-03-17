import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long[][] map, dp;
    static long answer;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        map = new long[N + 1][3];
        dp = new long[N + 1][3];
        answer = Long.MAX_VALUE;



        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) dp[1][j] = map[1][j];
                else dp[1][j] = Integer.MAX_VALUE;
            }

            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + map[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + map[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + map[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                answer = Math.min(answer, dp[N][j]);
            }
        }
        System.out.println(answer);
    }
}