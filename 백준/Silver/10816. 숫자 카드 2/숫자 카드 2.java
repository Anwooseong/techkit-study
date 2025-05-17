import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(upperBinarySearch(num)- lowerBinarySearch(num) + " ");
		}
		
		System.out.println(sb);
	}
	
	private static int lowerBinarySearch(int num) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if(num <= arr[mid]) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		return left;
	}
	
	private static int upperBinarySearch(int num) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(num < arr[mid]) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		return left;
	}
}