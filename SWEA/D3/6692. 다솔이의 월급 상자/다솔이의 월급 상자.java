import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N;
	static double answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			answer = 0.0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				double p = Double.parseDouble(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				answer += (p*x);
			}
			
			System.out.printf("#%d %.6f\n", testCase, answer);
		}
	}
}