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

public class Main {

    static int R, C;
    static char[][] maze;
    static int[][] fire, visited;
    static Queue<Point2> queueFire, queuePerson;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        maze = new char[R][C];
        fire = new int[R][C];
        visited = new int[R][C];
        queueFire = new LinkedList<>();
        queuePerson = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = sc.next();
            sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                char word = line.charAt(j);
                if (word == 'F') {
                    queueFire.offer(new Point2(i, j));
                    fire[i][j] = 1;
                }
                if (word == 'J') {
                    queuePerson.offer(new Point2(i, j));
                    visited[i][j] = 1;
                }
                maze[i][j] = word;
            }
        }

        fireBFS();
        int answer = movePersonBFS();
        System.out.println(answer == 0 ? "IMPOSSIBLE" : answer);
    }

    private static void fireBFS() {
        while (!queueFire.isEmpty()) {
            Point2 poll = queueFire.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (!(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)) {
                    if (fire[nextX][nextY] == 0 && maze[nextX][nextY] != '#') {
                        queueFire.offer(new Point2(nextX, nextY));
                        fire[nextX][nextY] = fire[poll.x][poll.y] + 1;
                    }
                }
            }
        }
    }

    private static int movePersonBFS() {
        while (!queuePerson.isEmpty()) {
            Point2 poll = queuePerson.poll();

            if (poll.x == R - 1 || poll.y == C - 1 || poll.x == 0|| poll.y == 0) {
                return visited[poll.x][poll.y];
            }

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (!(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)) {
                    if (maze[nextX][nextY] != '#' && visited[nextX][nextY] == 0 && (fire[nextX][nextY] > visited[poll.x][poll.y] + 1 || fire[nextX][nextY] == 0)) {
                        queuePerson.offer(new Point2(nextX, nextY));
                        visited[nextX][nextY] = visited[poll.x][poll.y] + 1;
                    }
                }

            }
        }
        return 0;
    }
}
