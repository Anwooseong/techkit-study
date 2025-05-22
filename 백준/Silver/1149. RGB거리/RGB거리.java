import java.io.*;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
            
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];
        
        for(int i = 0; i < N ;i++){
            st = new StringTokenizer(bf.readLine(), " ");
            for(int j = 0; j < 3; j++){
                int cost = Integer.parseInt(st.nextToken());
                arr[i][j] = cost;
            }
        }
        
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        dp[1][0] = Math.min(dp[0][1], dp[0][2]) + arr[1][0];
        dp[1][1] = Math.min(dp[0][0], dp[0][2]) + arr[1][1];
        dp[1][2] = Math.min(dp[0][0], dp[0][1]) + arr[1][2];
        
        //if(N == 2){
        //    System.out.println(Math.min(dp[1][0], Math.min(dp[1][1], dp[1][2])));
        //    return;
        //}
        
        for(int i = 2; i < N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }
        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}
}