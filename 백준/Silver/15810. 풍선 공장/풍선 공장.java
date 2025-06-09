import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] A;
	static long left, right;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		left = Long.MAX_VALUE;
		right = Long.MIN_VALUE;
		
		
		A = new int[N];
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			right = Math.max((long) A[i] * (long) M, right);
		}
		
		left = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			long cnt = calculate(mid);
			if(cnt >= M) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		System.out.println(left);
	}
	
	private static long calculate(long time) {
		long cnt = 0;
		for(int num : A) {
			cnt += (time / (long) num);
			if(cnt > M) break;
		}
		return cnt;
	}
}
