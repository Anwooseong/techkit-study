import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(bf.readLine());
            int[][] arr = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            for(int j = 0; j < 2; j++){
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                for(int k = 1; k < n + 1; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            if(n > 1){
                for(int j = 2; j < n + 1; j++){
                    dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                    dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
                }
            }

            System.out.println(dp[0][n] > dp[1][n] ? dp[0][n] : dp[1][n]);
        }
    }
}
