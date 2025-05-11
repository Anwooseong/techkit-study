import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N, sum, answer;
	static int[] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			arr = new int[N];
			sum = 0;
			answer = 0;
			
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			visited = new boolean[N+1][sum+1];
			dfs(0, 0);
			
			for(int i = 0; i < sum+1; i++) {
				if(visited[N][i]) answer++;
			}
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}

	private static void dfs(int L, int sum) {
		if(visited[L][sum]) return;
		visited[L][sum] = true;
		if(L == N) return;
		
		dfs(L+1, sum+arr[L]);
		dfs(L+1, sum);
	}
}

	