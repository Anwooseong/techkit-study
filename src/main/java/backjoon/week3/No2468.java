package backjoon.week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point2 {
    int x;
    int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class No2468 {
    static int N;
    static int[][] region;
    static int maxCount;
    static int maxHeight;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        region = new int[N][N];
        maxCount = Integer.MIN_VALUE;
        maxHeight = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int height = scanner.nextInt();
                region[i][j] = height;
                if (height > maxHeight) {
                    maxHeight = height;
                }
            }
            scanner.nextLine();
        }

        for (int i = 0; i <= maxHeight; i++) {
            boolean[][] visited = new boolean[N][N];
            Queue<Point2> queue = new LinkedList<>();
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (region[j][k] > i && !visited[j][k]) {
                        queue.offer(new Point2(j, k));
                        BFS(i, visited, queue);
                        cnt++;
                    }
                }
            }
            if (cnt > maxCount) {
                maxCount = cnt;
            }
        }

        System.out.println(maxCount);

    }

    static void BFS(int height, boolean[][] visited, Queue<Point2> queue) {
        while (!queue.isEmpty()) {
            Point2 poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];
                if (!(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)) {
                    if (region[nextX][nextY] > height && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.offer(new Point2(nextX, nextY));
                    }
                }
            }
        }
    }
}
