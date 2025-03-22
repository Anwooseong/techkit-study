import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] originMap, copyMap;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        init();

        int year = 0;
        while (true) {
            int cnt = 0;
            copyMap = copy();
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyMap[i][j] > 0 && !visited[i][j]) {
                        cnt++;
                        visited[i][j] = true;
                        dfs(i, j);
                    }
                }
            }
            year++;

            if (cnt >= 2) {
                System.out.println(year-1);
                return;
            } else if (cnt == 0) {
                System.out.println(0);
                return;
            }

            originMap = copyMap;
        }
    }

    static void dfs(int x, int y) {
        int zeroCnt = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (!isInRange(nextX, nextY)) continue;
            if (originMap[nextX][nextY] == 0) zeroCnt++;
        }
        copyMap[x][y] = Math.max(copyMap[x][y] - zeroCnt, 0);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (!isInRange(nextX, nextY)) continue;
            if (originMap[nextX][nextY] == 0) continue;
            if (visited[nextX][nextY]) continue;

            visited[nextX][nextY] = true;
            dfs(nextX, nextY);
        }

    }

    static int[][] copy() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = originMap[i][j];
            }
        }
        return copyMap;
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
