import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, totalCost, answer;
	static int[] m;
	static int[] c;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		m = new int[N];
		c = new int[N];
		totalCost = 0;
		answer = Integer.MAX_VALUE;
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			totalCost += c[i];
		}
		
		dp = new int[N][totalCost + 1];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= totalCost; j++) {
				if(i == 0) {
					if(c[i] <= j) {
						dp[i][j] = m[i];
					}
				}else {
					if(c[i] <= j) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c[i]] + m[i]);
					}else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}
		
		for(int i = 0; i <= totalCost; i++) {
			if(dp[N-1][i] >= M) {
				answer = Math.min(answer, i);
			}
		}
		
		System.out.println(answer);
	}
}


