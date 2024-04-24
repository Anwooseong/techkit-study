import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		StringTokenizer st;
		for(int testCase = 1; testCase <= T; testCase++) {
			
			int N = Integer.parseInt(bf.readLine());
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//첫열 마지막행 마지막열
			
			//두번째열 마지막-1행 마지막-1열
			
			//세번째열 마지막-2행 마지막-2열
			System.out.println("#"+testCase);
			
			for(int i = 0; i < N; i++) {
				for(int j = N-1; j>=0; j--) {
					System.out.print(arr[j][i]);
				}
				System.out.print(" ");
				
				for(int j = N-1; j>=0; j--) {
					System.out.print(arr[N - 1 - i][j]);
				}
				System.out.print(" ");
				
				for(int j = 0; j < N; j++) {
					System.out.print(arr[j][N - 1 - i]);
				}
				System.out.println();
				
			}
		}
		
	}

}
