import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M;
    static int[][] map;
    static Queue<Point> queue;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        init();
        int time = 0;
        int lastCheeseCnt = 0;
        while (true) {
            int count = removeCheese();
            time++;
            if (count == 0) {
                break;
            } else {
                lastCheeseCnt = count;
            }
        }
        System.out.println(time - 1);
        System.out.println(lastCheeseCnt);

    }

    static int removeCheese() {
        int removeCheeseCnt = 0;
        queue = new LinkedList<>();
        visited = new boolean[N][M];
        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(!isInRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (map[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                }else if(map[nx][ny] == 1) {
                    removeCheeseCnt++;
                    map[nx][ny] = 0;
                }
            }
        }
        return removeCheeseCnt;
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static void init() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}