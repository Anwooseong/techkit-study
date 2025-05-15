import java.io.*;
import java.util.*;

public class Solution {
	
	static int T;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			String line = bf.readLine();
			
			int lastNum = line.charAt(line.length()-1) - '0';
			System.out.printf("#%d %s\n", testCase, lastNum%2 == 0 ? "Even" : "Odd");
			
		}
	}
}