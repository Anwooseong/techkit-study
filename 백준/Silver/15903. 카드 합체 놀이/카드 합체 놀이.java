import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(bf.readLine(), " ");
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            priorityQueue.offer(arr[i]);
        }

        for (int i = 0; i < m; i++) {
            long poll1 = priorityQueue.poll();
            long poll2 = priorityQueue.poll();
            long sum = poll1 + poll2;
            priorityQueue.offer(sum);
            priorityQueue.offer(sum);
        }

        long sum = 0;
        for (Long aLong : priorityQueue) {
            sum += aLong;
        }

        System.out.println(sum);
    }
}
