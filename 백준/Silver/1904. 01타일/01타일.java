import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		if(N == 1) {
			System.out.println(1);
		}else if(N == 2) {
			System.out.println(2);
		}else {
			dp = new int[N+1];
			dp[1] = 1;
			dp[2] = 2;
			for(int i = 3; i <= N; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % 15746;
			}
			System.out.println(dp[N]);
		}
	}
}

