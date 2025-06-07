import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static long M, min, max, left, right;
	static long[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		arr = new long[N];
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		
		
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(bf.readLine());
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		
		left = min;
		right = max * M;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			long sum = calculate(mid);
			if(sum < M) { //시간을 늘려야됨 left + 1
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(right+1);
	}
	
	static private long calculate(long time) {
		long sum = 0;
		for(long line : arr) {
			sum += (time / line);
			
			if(sum > M) {
				break;
			}
		}
		return sum;
	}
}
