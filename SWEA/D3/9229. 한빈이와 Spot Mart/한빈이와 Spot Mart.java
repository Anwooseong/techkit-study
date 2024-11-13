import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, M;
	static Integer[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine(), " ");
			arr = new Integer[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o1-o2;
				}
			});
			
			int answer = -1;
			int left = 0;
			int right = N-1;
			while(left < right) {
				int sum = arr[left] + arr[right];
				if(sum < M) {
					answer = Math.max(sum, answer);
					left++;
				}else if(sum > M) {
					right--;
				}else {
					answer = M;
					break;
				}
			}
			
			System.out.println("#"+testCase+" "+answer);
		}
	}
}