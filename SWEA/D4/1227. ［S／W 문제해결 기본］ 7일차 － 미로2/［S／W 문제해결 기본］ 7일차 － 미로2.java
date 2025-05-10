import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, answer, startX, startY, endX, endY;
	static boolean[][] visited;
	static int[][] maze;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		T = 10;
		for(int testCase = 1; testCase <= T; testCase++) {
			int testNum = Integer.parseInt(bf.readLine());
			
			answer = 0;
			maze = new int[100][100];
			visited = new boolean[100][100];
			
			for(int i = 0; i < 100; i++) {
				String line = bf.readLine();
				for(int j = 0; j < 100; j++) {
					maze[i][j] = line.charAt(j) - '0';
					if(maze[i][j] == 2) {
						startX = i;
						startY = j;
					}
					
					if(maze[i][j] == 3) {
						endX = i;
						endY = j;
					}
				}
			}
			
			visited[startX][startY] = true;
			dfs(startX, startY);
			
			System.out.println("#"+testNum+" "+answer);
		}
	}

	private static void dfs(int x, int y) {
		if(answer == 1) {
			return;
		}
		
		if(x == endX && y == endY) {
			answer = 1;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(!isInRange(nextX, nextY)) continue;
			if(maze[nextX][nextY] == 1) continue;
			if(visited[nextX][nextY]) continue;
			
			visited[nextX][nextY] = true;
			dfs(nextX, nextY);
			visited[nextX][nextY] = false;
		}
		
	}
	
	private static boolean isInRange(int x, int y) {
		return x >= 0 && x < 100 && y >= 0 && y < 100;
	}
}

	