import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, L, U, X, answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			U = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			answer = 0;
			
			if(L <= X && X <= U) {
				answer = 0;
				System.out.printf("#%d %d\n", testCase, answer);
			}else if(X > U){
				answer = -1; 
				System.out.printf("#%d %d\n", testCase, answer);
			}else {
				answer = L - X;
				System.out.printf("#%d %d\n", testCase, answer);
			}
		}
	}
}