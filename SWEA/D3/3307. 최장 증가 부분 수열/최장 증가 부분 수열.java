import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N, answer;
	static int[] arr, dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			arr = new int[N];
			dp = new int[N];
			answer = 0;
			
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dp[0] = 1;
			for(int i = 1; i < N; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[i] > arr[j] && dp[j] >= dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
				
				answer = Math.max(answer, dp[i]);
			}
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}
}
