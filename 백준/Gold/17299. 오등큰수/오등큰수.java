import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N+1];
        int[] F = new int[1000001];
        int[] answer = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            F[arr[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<=N; i++) {
            while(!stack.empty() && F[arr[i]] > F[arr[stack.peek()]]) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.empty()) {
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}
