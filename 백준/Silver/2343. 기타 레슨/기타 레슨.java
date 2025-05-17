import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, totalSize; 
	static long left, right;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		totalSize = 0;
		left = 0;
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			totalSize += arr[i];
			left = Math.max(left, arr[i]);
		}
		
		right = totalSize;
		while(left <= right) {
			long mid = (left + right) / 2;
			
			int cnt = calculateCnt(mid);
			if(cnt > M) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		System.out.println(left);
	}

	private static int calculateCnt(long num) {
		int cnt = 1;
		long sum = num;
		for(int i = 0; i < N; i++) {
			if(sum < arr[i]) {
				sum = num;
				cnt++;
			}
			sum -= arr[i];
		}
		
		return cnt;
	}
}