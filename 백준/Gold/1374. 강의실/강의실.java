import java.io.*;
import java.util.*;

class Classroom implements Comparable<Classroom> {
    int num;
    int start;
    int finish;

    public Classroom(int num, int start, int finish) {
        this.num = num;
        this.start = start;
        this.finish = finish;
    }

    public int compareTo(Classroom o) {
        if (this.start == o.start) {
            return this.finish - o.finish;
        }
        return this.start - o.start;
    }
}

class Time implements Comparable<Time> {
    int start;
    int finish;

    public Time(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    public int compareTo(Time o) {
        return this.finish - o.finish;
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
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            classrooms[i] = new Classroom(num, start, finish);
        }
        Arrays.sort(classrooms);

        PriorityQueue<Time> pq = new PriorityQueue<>();
        pq.offer(new Time(classrooms[0].start, classrooms[0].finish));

        int answer = 1;
        for (int i = 1; i < N; i++) {

            while (!pq.isEmpty() && pq.peek().finish <= classrooms[i].start) {
                pq.poll();
            }
            pq.offer(new Time(classrooms[i].start, classrooms[i].finish));
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);

    }
}
