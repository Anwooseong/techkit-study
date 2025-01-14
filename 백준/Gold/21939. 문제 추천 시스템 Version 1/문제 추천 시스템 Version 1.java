import java.io.*;
import java.util.*;

class Problem {
    int num;
    int level;

    public Problem(int num, int level) {
        this.num = num;
        this.level = level;
    }
}

class DifficultProblem extends Problem implements Comparable<DifficultProblem> {


    public DifficultProblem(int num, int level) {
        super(num, level);
    }

    @Override
    public int compareTo(DifficultProblem o) {
        if (this.level == o.level) {
            return o.num - this.num;
        }
        return o.level - this.level;
    }
}

class EasyProblem extends Problem implements Comparable<EasyProblem> {


    public EasyProblem(int num, int level) {
        super(num, level);
    }

    @Override
    public int compareTo(EasyProblem o) {
        if (this.level == o.level) {
            return this.num - o.num;
        }
        return this.level - o.level;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<DifficultProblem> difficultQueue = new PriorityQueue<>();
        PriorityQueue<EasyProblem> easyQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            map.put(num, level);
            difficultQueue.offer(new DifficultProblem(num, level));
            easyQueue.offer(new EasyProblem(num, level));
        }
        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) { //어려움
                        while (true) {
                            if (map.containsKey(difficultQueue.peek().num)
                                    && difficultQueue.peek().level == map.get(difficultQueue.peek().num)) {
                                System.out.println(difficultQueue.peek().num);
                                break;
                            }
                            difficultQueue.poll();
                        }
                    } else if (x == -1) { //쉬움
                        while (true) {
                            if (map.containsKey(easyQueue.peek().num)
                                    && easyQueue.peek().level == map.get(easyQueue.peek().num)) {
                                System.out.println(easyQueue.peek().num);
                                break;
                            }
                            easyQueue.poll();
                        }
                    }
                    break;

                case "add":
                    int P = Integer.parseInt(st.nextToken()); //번호
                    int L = Integer.parseInt(st.nextToken()); //난이도
                    map.put(P, L);
                    difficultQueue.offer(new DifficultProblem(P, L));
                    easyQueue.offer(new EasyProblem(P, L));
                    break;

                case "solved":
                    P = Integer.parseInt(st.nextToken());
                    map.remove(P);
                    break;

            }
        }

    }
}
