import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N, answer;
	static char[][] map;
	static int[] dx = {-1,-1,0,1, 1,1,0,-1};
	static int[] dy = {0,1,1,1, 0,-1,-1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			
			N = Integer.parseInt(bf.readLine());
			map = new char[N][N];
			answer = 0;
			
			for(int i = 0; i < N; i++) {
				String line = bf.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '.' && isClean(i, j)) {
						answer++;
						dfs(i, j);
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					answer = map[i][j] == '.' ? answer+1 : answer;
				}
			}
			
			System.out.println("#"+testCase+" "+answer);
		}
	}
	
	private static void dfs(int x, int y) {
		int cnt = 0;
		for(int i = 0; i < 8; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(!isInRange(nextX, nextY)) continue;
			if(map[nextX][nextY] == '*') cnt++;
		}
		
		map[x][y] = (char)(cnt + '0');
		
		if(cnt == 0) {
			for(int i = 0; i < 8; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(!isInRange(nextX, nextY)) continue;
				if(map[nextX][nextY] == '.') {
					dfs(nextX, nextY);
				}
			}
		}
	}

	private static boolean isClean(int x, int y) {
		for(int i = 0; i < 8; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(!isInRange(nextX, nextY)) continue;
			if(map[nextX][nextY] == '*') return false;
		}
		return true;
	}

	private static boolean isInRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

	