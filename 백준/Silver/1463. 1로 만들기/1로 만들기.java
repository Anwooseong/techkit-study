import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(fun(N));
    }

    static int fun(int index) {
        if (dp[index] == Integer.MAX_VALUE) {
            if (index % 3 == 0) {
                if (index % 2 == 0) {
                    dp[index] = Math.min(fun(index / 3), Math.min(fun(index / 2), fun(index - 1))) + 1;
                } else {
                    dp[index] = Math.min(fun(index / 3), fun(index - 1)) + 1;
                }
            } else if (index % 2 == 0) {
                dp[index] = Math.min(fun(index / 2), fun(index - 1)) + 1;
            } else {
                dp[index] = fun(index - 1) + 1;
            }
        }
        return dp[index];
    }
}

