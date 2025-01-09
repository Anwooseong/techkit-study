import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int[][] map;
    static List<Point> list;
    static int[] cb;
    static int N, M, emptyCnt, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        cb = new int[M];
        answer = Integer.MAX_VALUE;

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(new Point(i, j));
                }
                if (map[i][j] == 0) {
                    emptyCnt++;
                }
            }
        }

        combi(0, 0);
        if (emptyCnt == 0) System.out.println(0);
        else System.out.println(answer == Integer.MAX_VALUE ? -1 : answer-1);
    }

    static void combi(int L, int start) {
        if (L == M) {
            //조합 뽑기
            int[][] visited = new int[N][N];
            int empty = emptyCnt;
            Queue<Point> queue = new LinkedList<>();
            for (int i : cb) {
                Point point = list.get(i);
                visited[point.x][point.y] = 1;
                queue.add(point);
            }

            while (!queue.isEmpty()) {
                Point poll = queue.poll();
                int x = poll.x;
                int y = poll.y;
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];
                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                    if (map[nextX][nextY] == 1) continue;
                    if (visited[nextX][nextY] != 0) continue;
                    queue.offer(new Point(nextX, nextY));
                    visited[nextX][nextY] = visited[x][y] + 1;
                    if (map[nextX][nextY] == 0) {
                        empty--;
                        if (empty == 0) {
                            answer = Math.min(answer, visited[nextX][nextY]);
                        }
                    }
                }
            }
            return;
        }
        for (int i = start; i < list.size(); i++) {
            cb[L] = i;
            combi(L+1, i+1);
        }
    }
}



















