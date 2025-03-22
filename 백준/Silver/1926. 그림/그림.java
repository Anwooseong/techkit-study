import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int pictureCnt, maxPicture, tmp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    tmp = 1;
                    pictureCnt++;
                    visited[i][j] = true;
                    dfs(i, j);
                    maxPicture = Math.max(maxPicture, tmp);
                }
            }
        }
        System.out.println(pictureCnt);
        System.out.println(maxPicture);
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (!isInRange(nextX, nextY)) continue;
            if (map[nextX][nextY] == 0) continue;
            if (visited[nextX][nextY]) continue;

            visited[nextX][nextY] = true;
            tmp++;
            dfs(nextX, nextY);
        }
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        pictureCnt = 0;
        maxPicture = 0;
        tmp = 0;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
