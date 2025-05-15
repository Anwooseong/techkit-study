import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N, sum, avg, answer;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			arr = new int[N];
			sum = 0;
			avg = 0;
			answer = 0;
			
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			avg = sum / N;
			
			for(int i = 0; i < N; i++) {
				if(arr[i] <= avg) {
					answer++;
				}
			}
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}
}