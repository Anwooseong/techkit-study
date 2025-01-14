import java.io.*;
import java.util.*;

class Number implements Comparable<Number> {
    int index;
    int num;

    public Number(int index, int num) {
        this.index = index;
        this.num = num;
    }

    public int compareTo(Number o) {
        if (this.num == o.num) {
            return this.index - o.index;
        }
        return this.num - o.num;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        PriorityQueue<Number> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pq.offer(new Number(i, arr[i]));
        }
        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    int index = Integer.parseInt(st.nextToken()) - 1;
                    int num = Integer.parseInt(st.nextToken());
                    arr[index] = num;
                    pq.offer(new Number(index, num));
                    break;
                case 2:
                    while (true) {
                        Number peek = pq.peek();
                        if (arr[peek.index] == peek.num) {
                            System.out.println(peek.index + 1);
                            break;
                        }
                        pq.poll();
                    }
                    break;
            }
        }
    }
}
