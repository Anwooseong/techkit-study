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

public class Main {

    static int N, M;
    static char[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new int[N][M];
                if (map[i][j] == 'L') {
                    int hour = BFS(i, j);
                    answer = Math.max(hour, answer);
                }
            }
        }

        System.out.println(answer);

    }

    static int BFS(int x, int y) {
        int hour = 0;
        Queue<Point1> queue = new LinkedList<>();
        visited[x][y] = 1;
        queue.offer(new Point1(x, y));

        while (!queue.isEmpty()) {
            Point1 poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (!(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)) {
                    if (visited[nextX][nextY] == 0 && map[nextX][nextY] == 'L') {
                        queue.offer(new Point1(nextX, nextY));
                        visited[nextX][nextY] = visited[poll.x][poll.y] + 1;
                        hour = visited[nextX][nextY];
                    }
                }
            }
        }
        return hour - 1;
    }
}
