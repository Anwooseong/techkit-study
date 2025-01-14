import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        Map<String, PriorityQueue<Integer>> gorillaList = new HashMap<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if (num == 1) {
                int k = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> pq = !gorillaList.containsKey(name) ? new PriorityQueue<>(Collections.reverseOrder()) : gorillaList.get(name);
                for (int j = 0; j < k; j++) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
                gorillaList.put(name, pq);
            } else {
                int b = Integer.parseInt(st.nextToken());
                if (!gorillaList.containsKey(name)) continue;
                PriorityQueue<Integer> pq = gorillaList.get(name);
                if (pq.size() <= b) {
                    while (!pq.isEmpty()) {
                        answer += pq.poll();
                    }
                } else {
                    for (int j = 0; j < b; j++) {
                        if (pq.isEmpty()) break;
                        answer += pq.poll();
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
