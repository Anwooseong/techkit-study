import java.io.*;
import java.util.*;

public class Solution {

	static int T, N, D, doorCnt, moveCnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			doorCnt = 0;
			moveCnt = 0;
			
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num == 1) {
					moveCnt = 0;
				}else {
					moveCnt++;
					if(moveCnt == D) {
						doorCnt++;
						moveCnt = 0;
					}
					
				}
			}
			
			System.out.printf("#%d %d\n", testCase, doorCnt);
		}
	}
}