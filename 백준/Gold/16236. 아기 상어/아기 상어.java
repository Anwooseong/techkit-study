import java.util.*;
import java.io.*;

class Shark implements Comparable<Shark>{
    int x;
    int y;
    int distance;

    public Shark(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }


    @Override
    public int compareTo(Shark o) {
        if (this.distance != o.distance) {
            return this.distance - o.distance;
        } else {
            if (this.x == o.x) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
    }
}

public class Main {

    static int N, babySize;
    static int[][] map;
    static Queue<Shark> queue;
    static PriorityQueue<Shark> pq;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        queue = new LinkedList<>();
        babySize = 2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    queue.add(new Shark(i, j, 0));
                }
            }
        }

        bfs(queue);
        int eat = 0;
        int time = 0;
        while (!pq.isEmpty()) {
            Shark poll = pq.poll();
            map[poll.x][poll.y] = 0;
            eat++;
            if (eat == babySize) {
                babySize++;
                eat = 0;
            }
            time += poll.distance;
            queue = new LinkedList<>();
            queue.offer(new Shark(poll.x, poll.y, 0));
            bfs(queue);
        }
        System.out.println(time);

    }

    static void bfs(Queue<Shark> queue) {
        pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        while (!queue.isEmpty()) {
            Shark poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if (!isRange(nextX, nextY)) continue;
                if (visited[nextX][nextY]) continue;
                if (map[nextX][nextY] > babySize) continue;
                visited[nextX][nextY] = true;
                queue.add(new Shark(nextX, nextY, poll.distance + 1));
                if (map[nextX][nextY] > 0 && map[nextX][nextY] < babySize) {
                    pq.offer(new Shark(nextX, nextY, poll.distance + 1));
                }
            }
        }
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}