import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N, sum, startX, startY, len, range;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String line = bf.readLine();
				for(int j = 0; j < N; j++) {
					arr[i][j] = line.charAt(j) - '0';
				}
			}
			
			startX = N / 2;
			startY = 0;
			range = N/2;
			len = N;
			sum = 0;
			
			//middle line
			for(int i = startY; i < startY+len; i++) {
				sum += arr[startX][i];
			}
			
			startY++;
			len -= 2;
			
			for(int gap = 1; gap <= range; gap++) {
				for(int j = startY; j < startY+len; j++) {
					sum += arr[startX-gap][j];
					sum += arr[startX+gap][j];
				}
				startY++;
				len -= 2;
			}
			
			System.out.println("#"+testCase+" "+sum);
			
		}
	}
	
	private static boolean isInRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

	