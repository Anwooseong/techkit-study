import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, M;
	static int[][] arr;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = 0;
			
			arr = new int[N+1][N+1];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[x][y] = 1;
				arr[y][x] = 1;
			}
			
			for(int i = 1; i <= N-2; i++) {
				for(int j = i+1; j <= N-1; j++) {
					if(arr[i][j] == 1) {
						dfs(i, j);
					}
				}
			}
			System.out.println("#"+testCase+" "+answer);
		}
	}
	static void dfs(int i, int j) {
		for(int k = j+1; k <= N; k++) {
			if(arr[k][i] == 1 && arr[k][j] == 1) {
				answer++;
			}
		}
	}
}










