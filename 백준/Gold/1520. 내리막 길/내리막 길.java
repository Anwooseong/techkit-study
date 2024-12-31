import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int answer;
    static int[][] map, visited;
    static final int dx[] = {-1, 1, 0, 0};
    static final int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = dfs(0, 0);
        System.out.println(answer);
    }

    static int dfs(int x, int y) {
        if (x == N-1 && y == M-1) return 1;
        if (visited[x][y] == -1) { //방금안했을때
            visited[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (map[x][y] > map[nextX][nextY]) visited[x][y] += dfs(nextX, nextY);
            }
        } else {
            return visited[x][y];
        }
        return visited[x][y];
    }
}
