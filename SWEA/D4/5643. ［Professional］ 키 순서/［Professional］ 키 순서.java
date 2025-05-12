import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N, M, answer;
	static int shorterCnt, tallerCnt;
	static boolean[] shorterVisited, tallerVisited;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine()); //학생 수
			M = Integer.parseInt(bf.readLine()); //비교 횟수
			answer = 0;
			arr = new int[N+1][N+1];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				arr[from][to] = 1;
			}
			
			for(int i = 1; i <= N; i++) {
				shorterVisited = new boolean[N+1];
				tallerVisited = new boolean[N+1];
				shorterCnt = 0;
				tallerCnt = 0;
				
				shorterDFS(i);
				tallerDFS(i);
				
				if(shorterCnt + tallerCnt == N - 1) {
					answer++;
				}
			}
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}

	private static void tallerDFS(int idx) {
		for(int i = 1; i <= N; i++) {
			if(arr[idx][i] == 1 && !tallerVisited[i]) {
				tallerVisited[i] = true;
				tallerCnt++;
				tallerDFS(i);
			}
		}
	}

	private static void shorterDFS(int idx) {
		for(int i = 1; i <= N; i++) {
			if(arr[i][idx] == 1 && !shorterVisited[i]) {
				shorterVisited[i] = true;
				shorterCnt++;
				shorterDFS(i);
			}
		}
	}
}

	