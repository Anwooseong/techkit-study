import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N;
	static int[][] arr, answer;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			
			arr = new int[N][N];
			visited = new boolean[N][N];
			answer = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String line = bf.readLine();
				for(int j = 0; j < N; j++) {
					arr[i][j] = line.charAt(j) - '0';
					answer[i][j] = Integer.MAX_VALUE;
				}
			}

			answer[0][0] = 0;
 			BFS();
 			System.out.println("#"+testCase+" "+answer[N-1][N-1]);
		}
	}
	
	private static void BFS() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0, 0});
		visited[0][0]= true;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			
			for(int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if(!isInRange(nextX, nextY)) continue;
				if((answer[x][y] + arr[nextX][nextY]) >= answer[nextX][nextY]) continue;
				answer[nextX][nextY] = answer[x][y] + arr[nextX][nextY];
				if(nextX == N-1 && nextY == N-1) continue;
				queue.offer(new int[] {nextX, nextY});
				
			}
		}
	}
	
	private static boolean isInRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

	