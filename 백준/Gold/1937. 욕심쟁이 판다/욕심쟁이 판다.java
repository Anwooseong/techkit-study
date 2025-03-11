import java.util.*;
import java.io.*;

public class Main {

    static int N, ans;
    static int[][] map, dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        ans = 0;
        map = new int[N + 2][N + 2];
        dp = new int[N + 2][N + 2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        System.out.println(ans);
    }

    static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (map[x][y] < map[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }
}