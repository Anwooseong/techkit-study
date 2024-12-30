import java.awt.*;
import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int N, L, R;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] map = initMap(bf, N);

        int cnt = 0;
        while (true) {
            boolean isFlag = false;
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        Queue<Point> savedQueue = new LinkedList<>();
                        int totalCnt = bfs(map, visited, i, j, savedQueue);
                        if (map[i][j] != totalCnt) {
                            isFlag = true;
                        }
                        changeMap(map, savedQueue, totalCnt);
                    }
                }
            }
            if (!isFlag) break;
            else cnt++;
        }
        System.out.println(cnt);
    }

    static void changeMap(int[][] map, Queue<Point> savedQueue, int totalCnt) {
        int value = totalCnt / savedQueue.size();
        while (!savedQueue.isEmpty()) {
            Point poll = savedQueue.poll();
            map[poll.x][poll.y] = value;
        }
    }

    static int bfs(int[][] map, boolean[][] visited, int x, int y, Queue<Point> savedQueue) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        savedQueue.offer(new Point(x, y));
        int totalCnt = map[x][y];
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if (visited[nextX][nextY]) continue;

                int gap = Math.abs(map[poll.x][poll.y] - map[nextX][nextY]);
                if (L <= gap && R >= gap) {
                    queue.offer(new Point(nextX, nextY));
                    savedQueue.offer(new Point(nextX, nextY));
                    totalCnt += map[nextX][nextY];
                    visited[nextX][nextY] = true;
                }

            }
        }
        return totalCnt;
    }

    private static int[][] initMap(BufferedReader bf, int N) throws IOException {
        StringTokenizer st;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return map;
    }
}
