import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] arr;
	static int N, K;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			answer = 0;
			
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(1, 0);
			dfs(1, arr[0]);
			System.out.println("#"+testCase+" "+answer);
		}
	}
	
	static void dfs(int L, int value) {
		if(value == K) {
			answer++;
			return;
		}
		if(L == N) return;
		dfs(L+1, value);
		dfs(L+1, value + arr[L]);
	}
}