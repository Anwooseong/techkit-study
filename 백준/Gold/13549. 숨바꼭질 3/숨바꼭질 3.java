import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];
        Arrays.fill(arr, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        arr[N] = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == K) break;

            int nextX = poll * 2;
            if (nextX >= 0 && nextX <= 100000 && arr[nextX] == -1) {
                queue.offer(nextX);
                arr[nextX] = arr[poll];
            }

            nextX = poll - 1;
            if (nextX >= 0 && nextX <= 100000 && arr[nextX] == -1) {
                queue.offer(nextX);
                arr[nextX] = arr[poll] + 1;
            }

            nextX = poll + 1;
            if (nextX >= 0 && nextX <= 100000 && arr[nextX] == -1) {
                queue.offer(nextX);
                arr[nextX] = arr[poll] + 1;
            }
        }
        System.out.println(arr[K]);
    }
}