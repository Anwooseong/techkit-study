import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] visited;
    static Map<Integer, Integer> zeroCntMap;
    static int groupId;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        zeroCntMap = new HashMap<>();
        visited = new int[N][M];
        groupId = 0;

        for (int i = 0; i < N; i++) {
            char[] line = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                int num = (int) line[j] - '0';
                map[i][j] = num;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0 && map[i][j] == 0) {
                    groupId++;
                    zeroCntMap.put(groupId, bfs(i, j, groupId));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    sb.append(0);
                } else if (map[i][j] == 1) {
                    int cnt = 1;
                    Set<Integer> groupSet = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if (!isInRange(nextX, nextY)) continue;
                        if (visited[nextX][nextY] == 0) continue;
                        groupSet.add(visited[nextX][nextY]);
                    }
                    for (int integer : groupSet) {
                        int groupCnt = zeroCntMap.get(integer);
                        cnt += groupCnt;
                    }
                    sb.append(cnt%10);
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int i, int j, int groupId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = groupId;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int k = 0; k < 4; k++) {
                int nextX = x + dx[k];
                int nextY = y + dy[k];
                if (!isInRange(nextX, nextY)) continue;
                if (map[nextX][nextY] == 1) continue;
                if (visited[nextX][nextY] != 0) continue;

                queue.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = groupId;
                cnt++;
            }
        }
        return cnt;
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}