import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[100001];
        int[] parent = new int[100001];
        Arrays.fill(dp, -1);
        dp[N] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == K) {
                sb.append(dp[x] + "\n");
                break;
            }

            int[] nextPositions = {x - 1, x + 1, 2 * x};
            for (int nextX : nextPositions) {
                if (nextX >= 0 && nextX <= 100000 && dp[nextX] == -1) {
                    queue.offer(nextX);
                    dp[nextX] = dp[x] + 1;
                    parent[nextX] = x;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());
    }
}