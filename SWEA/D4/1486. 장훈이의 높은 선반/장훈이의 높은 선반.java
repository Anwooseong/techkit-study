import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N, B, answer;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken()); //선반의 높이
			arr = new int[N];
			answer = Integer.MAX_VALUE;
		
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			
			System.out.println("#"+testCase+" "+answer);
		}
	}
	
	static void dfs(int L, int sum) {
		if(L == N) {
			if(sum >= B) {
				answer = Math.min(answer, sum - B);
			}
			return;
		}
		
		dfs(L+1, sum+arr[L]);
		dfs(L+1, sum);
	}
}

	