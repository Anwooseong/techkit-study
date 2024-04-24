import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int testNum = Integer.parseInt(bf.readLine());
			int[] arr = new int[101];
			int maxCnt = Integer.MIN_VALUE;
			int maxScore = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i<1000;i++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}

			for(int i = 0; i<101;i++) {
				if(maxCnt <= arr[i]) {
					maxCnt = arr[i];
					maxScore = i;
				}
			}
			System.out.println("#"+testNum+" "+maxScore);
			
		}
	}
}
