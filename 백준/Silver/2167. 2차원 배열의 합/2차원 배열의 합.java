import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
            }
        }

        int K = Integer.parseInt(bf.readLine());
        for (int TC = 0; TC < K; TC++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            System.out.println(dp[x][y] - dp[x][j-1] - dp[i-1][y] + dp[i-1][j-1]);
        }
    }
}