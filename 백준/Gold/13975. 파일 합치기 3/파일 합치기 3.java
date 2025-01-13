import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int K = Integer.parseInt(bf.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            st = new StringTokenizer(bf.readLine(), " ");
            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long answer = 0L;
            while (pq.size() != 1) {
                long poll1 = pq.poll();
                long poll2 = pq.poll();
                long tmp = poll1 + poll2;
                answer += tmp;
                pq.offer(tmp);
            }
            System.out.println(answer);
        }
    }
}
