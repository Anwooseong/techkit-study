package backjoon.week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point1 {
    int x;
    int y;

    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class No1012 {
    static int T, M, N, K, cnt = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            Queue<Point1> queue = new LinkedList<>();
            cnt = 0;
            M = scanner.nextInt();
            N = scanner.nextInt();
            K = scanner.nextInt();
            int[][] field = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                int y = scanner.nextInt();
                int x = scanner.nextInt();
                scanner.nextLine();
                field[x][y] = 1;
                queue.offer(new Point1(x, y));
            }

            while (!queue.isEmpty()) {
                Point1 poll = queue.poll();
                if (visited[poll.x][poll.y]) {
                    continue;
                }
                visited[poll.x][poll.y] = true;
                BFS(poll.x, poll.y, visited, field);
                cnt++;
            }
            System.out.println(cnt);
        }
    }

    static void BFS(int x, int y, boolean[][] visited, int[][] field) {
        Queue<Point1> points = new LinkedList<>();
        points.offer(new Point1(x, y));
        while (!points.isEmpty()) {
            Point1 poll = points.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];
                if (!(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)) {
                    if (field[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        points.offer(new Point1(nextX, nextY));
                    }
                }
            }
        }
    }
}
