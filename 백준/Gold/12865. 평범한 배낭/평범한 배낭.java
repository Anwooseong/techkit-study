import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[][] arr, dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][2];
		dp = new int[N+1][K+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken()); //W
			arr[i][1] = Integer.parseInt(st.nextToken()); //V
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) { //가방의 무게
				
				if(arr[i][0] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - arr[i][0]] + arr[i][1]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}


