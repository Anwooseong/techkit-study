import java.util.*;
import java.io.*;

public class Solution {
	
	static boolean[] check;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(bf.readLine());
			
			check = new boolean[10];
			
			String number = null;
			int num = N;
			while(!isAllCheck()) {
				number = String.valueOf(num);
				
				for(int i = 0; i < number.length(); i++) {
					check[(int) number.charAt(i) - 48] = true;
				}
				
				num += N;
			}
			System.out.println("#"+testCase+" "+number);
		}
	}

	private static boolean isAllCheck() {
		// TODO Auto-generated method stub
		boolean isTrue = true;
		for(int i = 0; i<10; i++) {
			if(check[i] == false) {
				isTrue = false;
				break;
			}
		}
		return isTrue;
	}
}
