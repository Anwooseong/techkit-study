import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] arr;
	static int result, totalExchangeCnt;
	static String numString;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			numString = st.nextToken();
			totalExchangeCnt = Integer.parseInt(st.nextToken());
			result = 0;
			
			arr = new int[numString.length()];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = (int) numString.charAt(i) - '0';
			}
			
			if (arr.length < totalExchangeCnt) {
                totalExchangeCnt = arr.length;
            }
			
			DFS(0, 0);
			System.out.println("#"+testCase+" "+result);
		}
	}

	private static void DFS(int depth, int start) {
		if(totalExchangeCnt == depth) {
			int num = 0;
			for(int i = arr.length - 1; i >= 0; i--) {
				num += (Math.pow(10, arr.length-1 - i) * arr[i]);
			}
			
			result = Math.max(result, num);
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				swap(i, j);
				DFS(depth+1, i);
				swap(i,j);
			}
		}
	}

	private static void swap(int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	
}