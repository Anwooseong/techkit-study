import java.util.*;
import java.io.*;

public class Main {

    static int N, K, L, dir;
    static int[][] map;
    static Queue<int[]> queue;
    static List<int[]> snakeList;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        queue = new LinkedList<>();
        dir = 1;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        L = Integer.parseInt(bf.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(bf.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            queue.offer(new int[]{X, C});
        }

        int time = 0;
        int cx = 0;
        int cy = 0;
        snakeList = new ArrayList<>();
        snakeList.add(new int[]{0, 0});
        while (true) {
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];
            time++;

            if (!isInRange(nx, ny)) break;
            if (crashSnake(nx, ny)) break;

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snakeList.add(new int[]{nx, ny});
            }else {
                snakeList.add(new int[]{nx, ny});
                snakeList.remove(0);
            }

            if (!queue.isEmpty()) {
                if (queue.peek()[0] == time) {
                    int[] poll = queue.poll();
                    int C = poll[1];
                    if (C == 'D') {
                        dir = (dir + 1) % 4;
                    } else if (C == 'L') {
                        dir = (dir - 1 + 4) % 4;
                    }
                }
            }
            cx = nx;
            cy = ny;
        }
        System.out.println(time);
    }

    static boolean crashSnake(int x, int y) {
        for (int i = 0; i < snakeList.size(); i++) {
            int[] snake = snakeList.get(i);
            if (x == snake[0] && y == snake[1]) {
                return true;
            }
        }
        return false;
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }


}