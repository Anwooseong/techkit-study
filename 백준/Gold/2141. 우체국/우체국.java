import java.util.*;
import java.io.*;

class House implements Comparable<House> {
    int position;
    int personCnt;

    public House(int position, int personCnt) {
        this.position = position;
        this.personCnt = personCnt;
    }

    @Override
    public int compareTo(House o) {
        return position - o.position;
    }
}

public class Main {

    static int N;
    static House[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        houses = new House[N];
        long totalPersonCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int position = Integer.parseInt(st.nextToken());
            int personCnt = Integer.parseInt(st.nextToken());
            houses[i] = new House(position, personCnt);
            totalPersonCnt += personCnt;
        }

        Arrays.sort(houses);

        long middle = (totalPersonCnt + 1) / 2;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += houses[i].personCnt;
            if (sum >= middle) {
                System.out.println(houses[i].position);
                return;
            }
        }
    }
}
