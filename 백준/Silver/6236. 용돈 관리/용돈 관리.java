import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, left, right;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		left = 1;
		right = 1;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			left = Math.max(left, arr[i]);
			right += arr[i];
			
		}
		
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			int cnt = calculate(mid);
			if(cnt > M) { //출금횟수가 더 많을 때는 돈이 적다는 거니까 출금 금액을 늘려야함.., 최소 금액이니까 lower
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		System.out.println(left);
	}
	
	private static int calculate(int num) {
		int cnt = 1;
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += arr[i];
			if(sum > num) {
				sum = arr[i];
				cnt++;
			}
		}
		return cnt;
	}
}


