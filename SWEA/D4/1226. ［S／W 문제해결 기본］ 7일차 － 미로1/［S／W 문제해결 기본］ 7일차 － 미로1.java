import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, startX, startY, endX, endY, answer;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		T = 10;
		for(int testCase = 1; testCase <= T; testCase++) {
			int t = Integer.parseInt(bf.readLine());
			
			arr = new int[16][16];
			visited = new boolean[16][16];
			answer = 0;
			
			for(int i = 0; i < 16; i++) {
				String line = bf.readLine();
				for(int j = 0; j < 16; j++) {
					arr[i][j] = line.charAt(j) - '0';
					if(arr[i][j] == 2) {
						startX = i;
						startY = j;
					}
					if(arr[i][j] == 3) {
						endX = i;
						endY = j;
					}
				}
			}
			
			dfs(startX, startY);
			System.out.println("#"+t+" "+answer);
		}
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		if(x == endX && y == endY) {
			//결과
			answer = 1;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(isInRange(nextX, nextY) && arr[nextX][nextY] != 1 && !visited[nextX][nextY]) {
				if(answer == 1) return;
				dfs(nextX, nextY);
			}
		}
	}

	private static boolean isInRange(int x, int y) {
		return x >= 0 && x < 16 && y >= 0 && y < 16;
	}
}

	