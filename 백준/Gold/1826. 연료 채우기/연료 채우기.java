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
//        int[][] arr = new int[N][2];
        PriorityQueue<Gas> gasQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gasQueue.offer(new Gas(a, b));
//            arr[i][0] = a;
//            arr[i][1] = b;
        }

        st = new StringTokenizer(bf.readLine(), " ");
        int L = Integer.parseInt(st.nextToken()); //위치
        int P = Integer.parseInt(st.nextToken()); //연료
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;
//        System.out.println("P = " + P);
        while (L > P) {
            if (!gasQueue.isEmpty() && gasQueue.peek().a <= P) {
                pq.offer(gasQueue.poll().b);
                continue;
            }

//            if (pq.isEmpty()) {
//                System.out.println(-1);
//                break;
//            }

            if (pq.isEmpty()) {
                break;
            }
            P += pq.poll();
//            System.out.println("P = " + P);
            cnt++;
        }
//        if (!pq.isEmpty())
//            System.out.println(cnt);
        System.out.println(L <= P ? cnt : -1);
//        for (int i = 0; i < N; i++) {
//            if (P >= arr[i][0]) {
//                pq.offer(arr[i][1]);
//            } else {
//                if (!pq.isEmpty()) {
//                    int poll = pq.poll();
//                    P += poll;
//                    cnt++;
//                }
//                if (P >= arr[i][0]) {
//                    pq.offer(arr[i][1]);
//                }
//            }
//        }
//        while (L > P) {
//            if (!pq.isEmpty()) {
//                P += pq.poll();
//                cnt++;
//            }
//        }
//        System.out.println(cnt);
    }
}
