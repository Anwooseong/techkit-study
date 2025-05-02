import java.io.*;
import java.util.*;

public class Solution {
	
	static int T;
	static int[][] arr;
	static Set<Integer> set;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			arr = new int[4][4];
			set = new HashSet<Integer>();
			
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(bf.readLine()," ");
				for(int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					dfs(0, 0, i, j);
				}
			}
			
			System.out.println("#"+testCase+" "+set.size());
		}
	}

	private static void dfs(int depth, int num, int x, int y) {
		num = (int) (Math.pow(10, depth) * arr[x][y] + num);
		
		if(depth == 6) {
			set.add(num);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(isInRange(nextX, nextY)){
				dfs(depth + 1, num, nextX, nextY);
			}
		}
	}
	
	private static boolean isInRange(int x, int y) {
		return x >= 0 && x < 4 && y >= 0 && y < 4;
	}
}

	