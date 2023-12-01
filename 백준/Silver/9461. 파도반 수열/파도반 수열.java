import java.io.*;
import java.util.*;

public class Main {

    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for(int i = 0; i<T; i++){
            int N = sc.nextInt();
            long[] dp = new long[101];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;
            dp[6] = 3;
            dp[7] = 4;
            dp[8] = 5;
            if(N >= 9){
                for(int j = 9; j<=N; j++){
                    dp[j] = dp[j-5]+dp[j-1];
                }
            }

            System.out.println(dp[N]);
        }
    }
}
