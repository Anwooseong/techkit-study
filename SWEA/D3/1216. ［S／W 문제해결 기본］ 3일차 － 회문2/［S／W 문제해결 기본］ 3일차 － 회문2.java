import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		for(int testCase = 1; testCase <= 10; testCase++) {
			int testNum = Integer.parseInt(bf.readLine());
			
			char[][] map = new char[100][100];
			for(int i = 0; i < 100; i++) {
				String line = bf.readLine();
				for(int j = 0; j < 100; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			int rowMaxLength = 100;
			//가로
			//4 - 2(maxLength)
			//5 abcba  0,2  3,5  5/2
			//3 aba 0,1 2,3  3/2
			while(rowMaxLength > 0) {
				boolean whileTrue = false;
				for(int j = 0; j <= 100 - rowMaxLength; j++) {
					for(int i = 0; i < 100; i++) {
						int left = j;
						int right = j + rowMaxLength - 1;
						boolean isTrue = true;
						while(left <= right) {
							if(map[i][left] == map[i][right]) {
								left++;
								right--;
							}else {
								isTrue = false;
								break;
							}
						}
						if(isTrue) {
							whileTrue = true;
							break;
						}
					}
				}
				if(whileTrue) {
					break;
				}
				rowMaxLength--;
			}
			
			
			//세로
			int columnMaxLength = 100;
			while(columnMaxLength > 0) {
				boolean whileTrue = false;
				for(int i = 0; i <= 100 - columnMaxLength; i++) {
					for(int j = 0; j < 100; j++) {
						int left = i;
						int right = i + columnMaxLength - 1;
						boolean isTrue = true;
						while(left <= right) {
							if(map[left][j] == map[right][j]) {
								left++;
								right--;
							}else {
								isTrue = false;
								break;
							}
						}
						if(isTrue) {
							whileTrue = true;
							break;
						}
					}
				}
				if(whileTrue) {
					break;
				}
				columnMaxLength--;
			}
			System.out.println("#"+testNum + " "+Math.max(rowMaxLength, columnMaxLength));
		}
	}
}