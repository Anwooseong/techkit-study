import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N;
	static int[] corridor;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			corridor = new int[201];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine()," ");
				int left = (Integer.parseInt(st.nextToken())+1)/2;
				int right = (Integer.parseInt(st.nextToken())+1)/2;
				
				int min = Math.min(left, right);
				int max = Math.max(left, right);
				for(int j = min; j <= max; j++) {
					corridor[j]++;
				}
			}
			
			Arrays.sort(corridor);
			System.out.printf("#%d %d\n",testCase, corridor[200]);
		}
	}
}

	