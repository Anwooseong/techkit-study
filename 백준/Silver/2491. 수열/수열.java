import java.io.*;
import java.util.*;

public class Main {
	
	static int N, highCnt, lowCnt, answer;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		highCnt = 1;
		lowCnt = 1;
		answer = 1;
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N; i++) {
			if(arr[i] >= arr[i-1]) {
				highCnt++;
			}else {
				highCnt = 1;
			}
			
			if(arr[i] <= arr[i-1]) {
				lowCnt++;
			}else {
				lowCnt = 1;
			}
			
			answer = Math.max(answer, Math.max(highCnt, lowCnt));
		}
		
		System.out.println(answer);
	}
}


