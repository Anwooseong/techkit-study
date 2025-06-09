import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, left, right;
	static int[] lamps;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		lamps = new int[M];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < M; i++) {
			lamps[i] = Integer.parseInt(st.nextToken());
		}
		
		left = 1;
		right = 100000;
		while(left <= right) {
			int mid = (left + right) / 2;
			
			boolean isSuccess = calculate(mid);
			if(isSuccess) {
				right = mid - 1; 
			}else {
				left = mid + 1;
			}
		}
		
		System.out.println(right + 1);
	}
	
	private static boolean calculate(int height) {
		int idx = lamps[0];
		int left = 0;
		int right = 0;
		
		if(idx - height > 0) {
			return false;
		}else {
			left = 0;
			right = idx + height;
		}
		
		for(int i = 1; i < M; i++) {
			idx = lamps[i];
			if(idx - height > right) {
				return false;
			}else {
				left = idx - height;
				right = idx + height;
			}
		}
		
		if(right < N) {
			return false;
		}
		
		return true;
	}
}
