import java.io.*;
import java.util.*;

public class Main {
	
	static int T, k, n;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			k = Integer.parseInt(bf.readLine());
			n = Integer.parseInt(bf.readLine());
			arr = new int[k+1][n+1];
			
			for(int i = 1; i <= n; i++) {
				arr[0][i] = i;
			}
			
			for(int i = 1; i <= k; i++) {
				for(int j = 1; j <= n; j++) {
					arr[i][j] = arr[i-1][j] + arr[i][j-1];
				}
			}
			
			System.out.println(arr[k][n]);
		}
	}
}
