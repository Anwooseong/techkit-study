import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			String line = bf.readLine();
			char num = '0';
			answer = 0;
			
			for(int i = 0; i < line.length(); i++) {
				char alpha = line.charAt(i);
				if(alpha != num) {
					num = num == '0' ? '1' : '0';
					answer++;
				}
			}
			
			System.out.println("#"+testCase+" "+answer);
		}
	}
}

	