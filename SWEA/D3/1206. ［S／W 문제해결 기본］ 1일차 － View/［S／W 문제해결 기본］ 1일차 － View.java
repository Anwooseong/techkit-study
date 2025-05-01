import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[] arr;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			arr = new int[N];
			answer = 0;
			
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); 
			}
			
			for(int i = 2; i <= N-3; i++) {
				answer += Math.max(0, arr[i] - Math.max(Math.max(arr[i-1], arr[i-2]), Math.max(arr[i+1], arr[i+2])));
			}
			
			System.out.println("#"+testCase+" "+answer);
		}
	}
}