import java.io.*;
import java.util.*;

class Gas implements Comparable<Gas>{
    int a;
    int b;

    public Gas(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int compareTo(Gas o) {
        return this.a - o.a;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Gas> gasQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gasQueue.offer(new Gas(a, b));
        }

        st = new StringTokenizer(bf.readLine(), " ");
        int L = Integer.parseInt(st.nextToken()); //위치
        int P = Integer.parseInt(st.nextToken()); //연료
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;
        while (L > P) {
            if (!gasQueue.isEmpty() && gasQueue.peek().a <= P) {
                pq.offer(gasQueue.poll().b);
                continue;
            }

            if (pq.isEmpty()) {
                break;
            }
            P += pq.poll();
            cnt++;
        }
        System.out.println(L <= P ? cnt : -1);
    }
}
