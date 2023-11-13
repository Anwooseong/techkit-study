package backjoon.week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class No2178 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();
        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                int num = (int) line.charAt(j) - 48;
                maze[i][j] = num;
            }
        }
        BFS();
        System.out.println(maze[N - 1][M - 1]);
    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (!(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)) {
                    if (!visited[nextX][nextY] && maze[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.offer(new Point(nextX, nextY));
                        maze[nextX][nextY] = maze[poll.x][poll.y] + 1;
                    }
                }
            }
        }
    }
}
