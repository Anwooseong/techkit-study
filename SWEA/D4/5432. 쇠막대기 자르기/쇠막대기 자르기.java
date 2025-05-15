import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, cnt, answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			String line = bf.readLine();
			
			cnt = 0;
			answer = 0;
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == '(') {
					cnt++;
				}else {
					cnt--;
					if(line.charAt(i-1) == '(') {
						//레이저
						answer += cnt;
					}else {
						answer++;
					}
				}
			}
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}
}