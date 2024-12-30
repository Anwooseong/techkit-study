import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    int cnt;
    boolean destroy;

    public Point(int x, int y, int cnt, boolean destroy) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.destroy = destroy;
    }
}

public class Main {

    static final int dx[] = {-1, 1, 0, 0};
    static final int dy[] = {0, 0, -1, 1};
    static final int NON_DESTROY = 0, DESTROY = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String line = bf.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = (int) line.charAt(j-1) - '0';
            }
        }

        int[][][] visited = new int[2][N + 1][M + 1];
        Queue<Point> queue = new LinkedList<>();
        visited[0][0][0] = 1;
        queue.offer(new Point(1, 1, 1, false));

        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            if (poll.x == N && poll.y == M) {
                System.out.println(poll.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (nextX <= 0 || nextX > N || nextY <= 0 || nextY > M) continue;

                if (map[nextX][nextY] == 0) {
                    if (!poll.destroy && visited[NON_DESTROY][nextX][nextY] == 0) {
                        queue.offer(new Point(nextX, nextY, poll.cnt + 1, false));
                        visited[NON_DESTROY][nextX][nextY] = poll.cnt + 1;
                    } else if (poll.destroy && visited[DESTROY][nextX][nextY] == 0) {
                        queue.offer(new Point(nextX, nextY, poll.cnt + 1, true));
                        visited[DESTROY][nextX][nextY] = poll.cnt + 1;
                    }
                } else {
                    if (!poll.destroy) {
                        queue.offer(new Point(nextX, nextY, poll.cnt + 1, true));
                        visited[DESTROY][nextX][nextY] = poll.cnt + 1;
                    }
                }
            }
        }
        System.out.println(-1);


    }
}
