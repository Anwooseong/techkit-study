package backjoon.week5;

import java.util.Arrays;
import java.util.Scanner;

class Cow{
    int arriveTime;
    int searchTime;

    public Cow(int arriveTime, int searchTime) {
        this.arriveTime = arriveTime;
        this.searchTime = searchTime;
    }
}

public class No14469 {
    static int N;
    static Cow[] cows;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cows = new Cow[N];
        //1
        //2 3
        //4
        //5 6 7 8 9 10 11 12
        //12 13 14 15
        for (int i = 0; i < N; i++) {
            cows[i] = new Cow(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(cows, (c1, c2) -> c1.arriveTime - c2.arriveTime);

        int cnt = 0;
        int answer = 0;
        while (cnt < N) {
            if (cows[cnt].arriveTime > answer) {
                answer++;
            } else {
                answer += cows[cnt].searchTime;
                cnt++;
            }
        }
        System.out.println(answer);


    }
}
