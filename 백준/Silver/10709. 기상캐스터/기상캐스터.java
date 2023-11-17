import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point4 {
    int x;
    int y;

    public Point4(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] sky;
    static boolean[][] visited;
    static int H, W;
    static Queue<Point4> queue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        H = scanner.nextInt();
        W = scanner.nextInt();
        sky = new int[H][W];
        visited = new boolean[H][W];
        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            String line = scanner.next();
            scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'c') {
                    queue.offer(new Point4(i, j));
                    sky[i][j] = 0;
                    visited[i][j] = true;
                } else {
                    sky[i][j] = -1;
                }
            }
        }

        BFS();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(sky[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            Point4 poll = queue.poll();
            int X = poll.x;
            int nextY = poll.y + 1;
            if (nextY < W && !visited[X][nextY]) {
                queue.offer(new Point4(X, nextY));
                visited[X][nextY] = true;
                sky[X][nextY] = sky[poll.x][poll.y] + 1;
            }
        }
    }
}
