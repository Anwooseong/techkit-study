import java.io.*;
import java.util.*;

public class Main {
	
	static int M, N;
	static int[] snacks;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		long left = 1;
		long right = 1;
		snacks = new int[N];
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			snacks[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, snacks[i]);
		}
		
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			long cnt = calculateSnack(mid);
			if(cnt >= M) {//과자의 갯수가 조카 수보다 많으면 과자의 길이를 늘려야함(left = mid + 1) 
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		System.out.println(left - 1 == 0 ? 0 : left - 1);
	}
	
	private static long calculateSnack(long num) {
		long sum = 0;
		
		for(int i = 0; i < N; i++) {
			sum += (snacks[i] / num);
		}
		
		return sum;
	}
}


