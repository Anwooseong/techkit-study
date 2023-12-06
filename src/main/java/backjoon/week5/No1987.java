package backjoon.week5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No1987 {

    static int R, C;
    static char[][] maze;
    static Map<Character, Boolean> visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        maze = new char[R][C];
        visited = new HashMap<>();
        answer = 0;

        for (int i = 0; i < R; i++) {
            String line = sc.next();
            sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                char alphabet = line.charAt(j);
                maze[i][j] = alphabet;
                if (!visited.containsKey(alphabet)) {
                    visited.put(alphabet, false);
                }
            }
        }

        DFS(0, 0, 0);
        System.out.println(answer);
    }

    static void DFS(int x, int y, int cnt) {
        if (x < 0 || x >= R || y < 0 || y >= C) {
            answer = Math.max(answer, cnt);
            return;
        }
        if (visited.get(maze[x][y])) {
            answer = Math.max(answer, cnt);
            return;
        }
        visited.put(maze[x][y], true);
        DFS(x + 1, y, cnt + 1);
        DFS(x - 1, y, cnt + 1);
        DFS(x, y + 1, cnt + 1);
        DFS(x, y - 1, cnt + 1);
        visited.put(maze[x][y], false);

    }
}
