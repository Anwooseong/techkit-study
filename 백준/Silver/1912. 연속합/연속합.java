import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] numList;
    static ArrayList<Integer> dp = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        numList = new int[N];

        for (int i = 0; i < N; i++) {
            numList[i] = scanner.nextInt();
        }

        result(0);
        System.out.println(max(dp));
    }

    static void result(int n) {
        if (n == N) {
            return;
        } else {
            if (n == 0) {
                dp.add(numList[0]);
            } else {
                dp.add(Math.max(dp.get(n - 1) + numList[n], numList[n]));
            }
            result(n + 1);
        }
    }

    static int max(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}

