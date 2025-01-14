import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine(), " ");
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long answer = 1L;
            while (pq.size() > 1) {
                long slime1 = pq.poll();
                long slime2 = pq.poll();
                long composition = slime1 * slime2;

                answer = (answer * (composition%1000000007)) % 1000000007;
                pq.offer(composition);
            }
            System.out.println(answer);
        }
    }
}
