import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, testNum, len, answer;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = 10;
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			testNum = Integer.parseInt(st.nextToken());
			len = Integer.parseInt(st.nextToken());
			answer = 0;
			
			arr = new int[100][2];
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < len; i++) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				
				if(arr[left][0] == 0) {
					arr[left][0] = right;
				}else {
					arr[left][1] = right;
				}
			}
			
			dfs(arr[0][0]);
			dfs(arr[0][1]);
			
			System.out.println("#"+testNum+" "+answer);
		}
	}

	private static void dfs(int start) {
		if(answer == 1) {
			return;
		}
		
		if(start == 0) {
			return;
		}
		
		if(start == 99) {
			answer = 1;
			return;
		}
		
		dfs(arr[start][0]);
		dfs(arr[start][1]);
	}
}

	