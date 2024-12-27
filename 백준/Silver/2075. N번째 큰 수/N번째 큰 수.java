import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    int x;
    int y;
    int num;

    public Point(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public int compareTo(Point o) {
        return o.num - this.num;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Point> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.offer(new Point(N - 1, i, map[N - 1][i]));
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            Point poll = priorityQueue.poll();
            answer = poll.num;
            if (poll.x - 1 < 0) continue;
            int x = poll.x - 1;
            int y = poll.y;
            int num = map[x][y];
            priorityQueue.offer(new Point(x, y, num));
        }

        System.out.println(answer);

    }
}
