package backjoon.week3;

import java.util.*;

class Point3 {
    int x;
    int y;

    public Point3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class No2583 {
    static int N, M, K;
    static int[][] region;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> answers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();
        scanner.nextLine();
        region = new int[N][M];
        answers = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int leftUpY = scanner.nextInt();
            int leftUpX = scanner.nextInt();
            int rightDownY = scanner.nextInt() - 1;
            int rightDownX = scanner.nextInt() - 1;
            scanner.nextLine();
            for (int j = leftUpX; j <= rightDownX; j++) {
                for (int k = leftUpY; k <= rightDownY; k++) {
                    region[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (region[i][j] == 0) {
                    region[i][j] = 1;
                    answers.add(BFS(i, j));
                }
            }
        }

        System.out.println(answers.size());
        Collections.sort(answers);
        for (Integer answer : answers) {
            System.out.print(answer + " ");
        }
    }

    static int BFS(int x, int y) {
        int count = 1;
        Queue<Point3> queue = new LinkedList<>();
        queue.offer(new Point3(x, y));

        while (!queue.isEmpty()) {
            Point3 poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];
                if (!(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)) {
                    if (region[nextX][nextY] == 0) {
                        count++;
                        queue.offer(new Point3(nextX, nextY));
                        region[nextX][nextY] = 1;
                    }
                }

            }

        }

        return count;
    }
}
