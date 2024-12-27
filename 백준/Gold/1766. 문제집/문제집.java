import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            list.get(left).add(right);
            arr[right]++;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                priorityQueue.offer(i);
            }
        }
        while (!priorityQueue.isEmpty()) {
            int poll = priorityQueue.poll();
            System.out.print(poll + " ");
            List<Integer> pollList = list.get(poll);
            for (int i = 0; i < pollList.size(); i++) {
                int num = pollList.get(i);
                arr[num]--;
                if (arr[num] == 0) {
                    priorityQueue.offer(num);
                }
            }
        }

    }
}
