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
    static List<Point> virusList;
    static int ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virusList = new ArrayList<>();
        map = new int[N][N];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Point(i, j));
                }
            }
        }

        boolean[] visited = new boolean[virusList.size()];
        combination(visited, 0, M);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void combination(boolean[] visited, int start, int r) {
        if (r == 0) {
            List<Integer> combi = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    combi.add(i);
                }
            }
            solve(combi);
            return;
        }

        for (int i = start; i < virusList.size(); i++) {
            visited[i] = true;
            combination(visited, i + 1, r - 1);
            visited[i] = false;
        }
    }

    static void solve(List<Integer> combi) {
        int[][] virusMap = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();

        for (int index : combi) {
            Point point = virusList.get(index);
            visited[point.x][point.y] = true;
            queue.offer(point);
        }

        int time = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isInRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                virusMap[nx][ny] = virusMap[x][y] + 1;
                time = virusMap[nx][ny];
                queue.offer(new Point(nx, ny));
            }
        }

        boolean result = completeVirus(visited);
        if (result) ans = Math.min(ans, time);
    }

    static boolean completeVirus(boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 || map[i][j] == 2) {
                    if (!visited[i][j]) return false;
                }
            }
        }
        return true;
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}