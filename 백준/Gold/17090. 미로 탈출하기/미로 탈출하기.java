import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static char[][] map;
    static int[][] resultMap;
    static final int NOT_SEARCH = 0, NOT_FINISHED = 1, FINISHED = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new char[N][M];
        resultMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j];
            }
        }

        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (resultMap[i][j] == NOT_SEARCH) {
                    if (dfs(i, j, visited) == FINISHED) {
                        answer++;
                    }
                } else if (resultMap[i][j] == FINISHED) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static int dfs(int x, int y, boolean[][] visited) {
        if (isFinish(x, y)) return FINISHED;

        if (visited[x][y]) return resultMap[x][y];

        visited[x][y] = true;
        int nextX, nextY;
        char dir = map[x][y];
        switch (dir) {
            case 'L': nextX = x; nextY = y - 1; break;
            case 'R': nextX = x; nextY = y + 1; break;
            case 'U': nextX = x - 1; nextY = y; break;
            default: nextX = x + 1; nextY = y; break;
        }

        int result = dfs(nextX, nextY, visited);
        resultMap[x][y] = result;

        return result;
    }

    static boolean isFinish(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}
