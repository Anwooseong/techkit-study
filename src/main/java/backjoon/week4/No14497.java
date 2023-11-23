package backjoon.week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point3 {
    int x;
    int y;

    public Point3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class No14497 {

    static int N, M;
    static int junanX, junanY, oppX, oppY;
    static char[][] map;
    static int[][] visited;
    static Queue<Point3> queue;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        junanX = sc.nextInt() - 1;
        junanY = sc.nextInt() - 1;
        oppX = sc.nextInt() - 1;
        oppY = sc.nextInt() - 1;
        sc.nextLine();

        map = new char[N][M];

        answer = 0;

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        BFS();
        System.out.println(answer);

    }

    static void BFS() {
        queue = new LinkedList<>();
        while (true) {
            queue.offer(new Point3(junanX, junanY));
            visited = new int[N][M];
            answer++;
            while (!queue.isEmpty()) {
                Point3 poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = poll.x + dx[i];
                    int nextY = poll.y + dy[i];
                    if (!(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)) {
                        if (visited[nextX][nextY] == 0) {
                            if (map[nextX][nextY] == '0') {
                                visited[nextX][nextY] = 1;
                                queue.offer(new Point3(nextX, nextY));
                            } else if (map[nextX][nextY] == '#') {
                                return;
                            } else if (map[nextX][nextY] == '1') {
                                visited[nextX][nextY] = 1;
                                map[nextX][nextY] = '0';
                            }
                        }
                    }
                }
            }
        }
    }
}
