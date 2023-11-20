package backjoon.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class No15686 {

    static int N, M;
    static int[][] map;
    static List<Point> stores;
    static List<Point> house;
    static Point[] combi;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        stores = new ArrayList<>();
        house = new ArrayList<>();
        combi = new Point[M];
        answer = Integer.MAX_VALUE;
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                if (num == 2) {
                    stores.add(new Point(i, j));
                }
                if (num == 1) {
                    house.add(new Point(i, j));
                }
                map[i][j] = num;
            }
            sc.nextLine();
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    static void DFS(int L, int s) {
        if (L == M) {
            int totalChickenDistance = 0;
            for (int i = 0; i < house.size(); i++) {
                int chickenDistance = Integer.MAX_VALUE;
                Point housePoint = house.get(i);
                for (int j = 0; j < M; j++) {
                    int distanceX = Math.abs(housePoint.x - combi[j].x);
                    int distanceY = Math.abs(housePoint.y - combi[j].y);
                    chickenDistance = Math.min(chickenDistance, distanceX + distanceY);
                }
                totalChickenDistance += chickenDistance;
            }
            answer = Math.min(totalChickenDistance, answer);
        } else {
            for (int i = s; i <= stores.size() - 1; i++) {
                combi[L] = stores.get(i);
                DFS(L + 1, i + 1);
            }
        }
    }
}
