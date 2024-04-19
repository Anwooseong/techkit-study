import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int[] dp = new int[N + 1];

        for(int i = 1; i <  N + 1; i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
