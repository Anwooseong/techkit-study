import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stairs = new int[N+1];
        dp = new int[N+1];
        
        for(int i = 1;i<=N; i++){
            stairs[i] = sc.nextInt();
        }
        
        dp[1] = stairs[1];
        if(N >= 2){
            dp[2] = stairs[1]+stairs[2];
        
            for(int i = 3; i<=N; i++){
                dp[i] = Math.max(dp[i-2], dp[i-3]+stairs[i-1])+stairs[i];
            }
        }
        
        System.out.println(dp[N]);
    }
}
