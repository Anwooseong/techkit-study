import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(bf.readLine());
			int[][] arr = new int[N][N];
			
			char direct = 'E';
			int left = 0;
			int right = N-1;
			int top = 0;
			int bottom = N-1;
			int nowNum = 1;
			int nextX = 0;
			int nextY = 0;
			
			if(N == 1) {
				System.out.println("#"+testCase);
				System.out.println(1);
			}else {
				while(arr[nextX][nextY] == 0) {
					if(direct == 'E') {
						for(int i = left; i <= right; i++) {
							arr[top][i] = nowNum;
							nowNum++;
						}
						top++;
						direct = 'S';
						nextX = top;
						nextY = right;
					}else if(direct == 'S') {
						for(int i = top; i <= bottom; i++) {
							arr[i][right] = nowNum;
							nowNum++;
						}
						right--;
						direct = 'W';
						nextX = bottom;
						nextY = right;
					}else if(direct == 'W') {
						for(int i = right; i >= left; i--) {
							arr[bottom][i] = nowNum;
							nowNum++;
						}
						bottom--;
						direct = 'N';
						nextX = bottom;
						nextY = left;
					}else if(direct == 'N') {
						for(int i = bottom; i >= top; i--) {
							arr[i][left] = nowNum;
							nowNum++;
						}
						left++;
						direct = 'E';
						nextX = top;
						nextY = left;
					}
				}
				
				System.out.println("#"+testCase);
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						System.out.print(arr[i][j]);
						if(j != N-1) {
							System.out.print(" ");
						}
					}
					System.out.println();
				}
			}
			
			
		}
	}
}
