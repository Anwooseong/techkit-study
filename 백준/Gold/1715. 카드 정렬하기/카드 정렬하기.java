import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.offer(Long.parseLong(bf.readLine()));
        }

        long sum = 0;
        while (priorityQueue.size() != 1) {
            Long poll1 = priorityQueue.poll();
            Long poll2 = priorityQueue.poll();
            sum += poll1 + poll2;
            priorityQueue.offer(poll1 + poll2);
        }

        System.out.println(sum);
    }
}
