import java.io.*;
import java.util.*;

public class Main {
	
	static int N, lengthOfLIS;
	static int[] arr, LIS;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		LIS = new int[N];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS[0] = arr[0];
		lengthOfLIS = 1;
		
		for(int i = 1; i < N; i++) {
			int num = LIS[lengthOfLIS - 1];
			
			if(num < arr[i]) {
				lengthOfLIS++;
				LIS[lengthOfLIS - 1] = arr[i];
			}else {
				int idx = binarySearch(arr[i]);
//				System.out.println(i+"/"+"idx="+idx);
				LIS[idx] = arr[i];
			}
		}
		
		System.out.println(lengthOfLIS);
	}
	
	private static int binarySearch(int num) {
		int left = 0;
		int right = lengthOfLIS - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
		
			if(num > LIS[mid]) {
				left = mid + 1;
//				System.out.println(left);
			}else {
				right = mid - 1;
//				System.out.println(right);
			}
		}
		
		return right + 1;
	}
}


