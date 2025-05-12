import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N, answer;
	static boolean[] visited;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			arr = new int[N];
			visited = new boolean[N];
			answer = 0;
			
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//처음에는 무조건 left 우선(조건에 오른쪽이 더 높으면 안된다는 조건)
			for(int i = 0; i < N; i++) {
				
				visited[i] = true;
				DFS(0, arr[i], 0);
				visited[i] = false;
			}
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}
	
	private static void DFS(int L, int leftSum, int rightSum) {
		if(leftSum < rightSum) return;
		
		if(L == N-1) {
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			DFS(L+1, leftSum + arr[i], rightSum);
			DFS(L+1, leftSum, rightSum + arr[i]);
			visited[i] = false;
		}
	}
}