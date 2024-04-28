import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		StringTokenizer st;
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(bf.readLine());
			
			st = new StringTokenizer(bf.readLine()," ");
			int[] arr = new int[N];
			int[] dp = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dp[0] = 1;
			int max = 1;
			for(int i = 1; i < N; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && dp[i] <= dp[j]) {
						dp[i] = dp[j] + 1;
					}
				}
			}
			for(int num : dp) {
				max = Math.max(num, max);
			}
			System.out.println("#"+testCase+" "+max);
		}
	}
}