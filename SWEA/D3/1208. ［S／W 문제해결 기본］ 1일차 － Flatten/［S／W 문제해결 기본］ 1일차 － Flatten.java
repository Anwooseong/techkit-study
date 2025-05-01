import java.io.*;
import java.util.*;

public class Solution {
	
	static int dumpCnt, answer;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		for(int testCase = 1; testCase <= T; testCase++) {
			dumpCnt = Integer.parseInt(bf.readLine());
			answer = Integer.MAX_VALUE;
			
			st = new StringTokenizer(bf.readLine(), " ");
			
			arr = new int[100];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < dumpCnt; i++) {
				Arrays.sort(arr);
				int gap = arr[arr.length-1]-arr[0];
				if(gap == 0 || gap == 1) break;
				arr[0]++;
				arr[arr.length-1]--;
				
			}
			Arrays.sort(arr);
			System.out.println("#"+testCase+" "+(arr[arr.length-1]-arr[0]));
		}
	}
}