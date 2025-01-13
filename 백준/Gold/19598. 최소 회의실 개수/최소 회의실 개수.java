import java.io.*;
import java.util.*;

class Classroom implements Comparable<Classroom> {
    int start;
    int finish;

    public Classroom(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    public int compareTo(Classroom c) {
        if (this.start == c.start) {
            return this.finish - c.finish;
        }
        return this.start - c.start;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        Classroom[] classrooms = new Classroom[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            classrooms[i] = new Classroom(start, finish);
        }
        Arrays.sort(classrooms);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(classrooms[0].finish);
        int answer = 1;
        for (int i = 1; i < N; i++) {
            while (!pq.isEmpty() && pq.peek() <= classrooms[i].start) {
                pq.poll();
            }
            pq.offer(classrooms[i].finish);
            answer = Math.max(answer, pq.size());
        }
        System.out.println(answer);
    }
}
