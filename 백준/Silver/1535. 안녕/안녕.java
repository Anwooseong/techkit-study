import java.util.Scanner;

public class Main {

    static int N, answer;
    static int[] L, J;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        answer = 0;
        L = new int[N];
        J = new int[N];
        for (int i = 0; i < N; i++) {
            L[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            J[i] = sc.nextInt();
        }

        dfs(0, 0, 100);
        System.out.println(answer);
    }

    private static void dfs(int index, int score, int hp) {
        if (index == N && hp > 0) {
            answer = Math.max(score, answer);
            return;
        }
        if (hp > 0) {
            dfs(index + 1, score + J[index], hp - L[index]);
            dfs(index + 1, score, hp);
        }
        return;
    }
}
