import java.util.*;
import java.io.*;

public class Main {

    static int R, C, answer;
    static char[][] map;
    static Queue<int[]> dochiQueue, waterQueue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        dochiQueue = new LinkedList<>();
        waterQueue = new LinkedList<>();
        answer = Integer.MAX_VALUE;


        for (int i = 0; i < R; i++) {
            char[] line = bf.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j];
                if (map[i][j] == 'S') {
                    dochiQueue.offer(new int[]{i, j, 0});
                }
                if (map[i][j] == '*') {
                    waterQueue.offer(new int[]{i, j});
                }
            }
        }

        while(!dochiQueue.isEmpty()) {
            int waterSize = waterQueue.size();
            for (int i = 0; i < waterSize; i++) {
                int[] water = waterQueue.poll();
                int x = water[0], y = water[1];
                for (int j = 0; j < 4; j++) {
                    int nextX = x + dx[j];
                    int nextY = y + dy[j];
                    if (!isInRange(nextX, nextY)) continue;
                    if (map[nextX][nextY] == 'D' || map[nextX][nextY] == 'S' || map[nextX][nextY] == '*' || map[nextX][nextY] == 'X') continue;
                    map[nextX][nextY] = '*';
                    waterQueue.offer(new int[]{nextX, nextY});
                }
            }

            int dochiSize = dochiQueue.size();
            for (int i = 0; i < dochiSize; i++) {
                int[] dochi = dochiQueue.poll();
                int x = dochi[0], y = dochi[1], time = dochi[2];
                for (int j = 0; j < 4; j++) {
                    int nextX = x + dx[j];
                    int nextY = y + dy[j];
                    if (!isInRange(nextX, nextY)) continue;
                    if (map[nextX][nextY] == 'D') {
                        answer = Math.min(answer, time + 1);
                        break;
                    }
                    if (map[nextX][nextY] == '.') {
                        map[nextX][nextY] = 'S';
                        dochiQueue.offer(new int[]{nextX, nextY, time + 1});
                    }
                }
            }
        }


        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);

    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }


}