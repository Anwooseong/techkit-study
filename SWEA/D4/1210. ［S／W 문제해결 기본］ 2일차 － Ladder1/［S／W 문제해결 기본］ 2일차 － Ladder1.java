import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, endX, endY;
	static int[][] ladder;
	static boolean[][] visited;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = 10;
		for(int testCase = 1; testCase <= T; testCase++) {
			int t = Integer.parseInt(bf.readLine());
			ladder = new int[100][100];
			visited = new boolean[100][100];
			endX = 0;
			endY = 0;
			answer = 0;
			
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				for(int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j] == 2) {
						endX = i;
						endY = j;
						visited[endX][endY] = true;
					}
				}
			}
			
			dfs(endX, endY);
			System.out.println("#"+t+" "+answer);
		}
	}
	
	private static void dfs(int x, int y) {
		if(x == 0) {
			//결과
			answer = y;
			return;
		}
		
		if(isInRange(x, y-1) && ladder[x][y-1] == 1 && !visited[x][y-1]) { //left
			visited[x][y-1] = true;
			dfs(x, y-1);
		}else if(isInRange(x, y+1) && ladder[x][y+1] == 1 && !visited[x][y+1]) { //right
			visited[x][y+1] = true;
			dfs(x, y+1);
		}else { //up
			visited[x-1][y] = true;
			dfs(x-1, y);
		}
		
	}

	private static boolean isInRange(int x, int y) {
		return x >= 0 && x < 100 && y >= 0 && y < 100;
	}
}

	