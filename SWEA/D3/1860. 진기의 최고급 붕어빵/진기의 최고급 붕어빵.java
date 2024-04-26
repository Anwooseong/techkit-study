import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		StringTokenizer st;
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] users = new int[N];
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < N; i++) {
				users[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(users);
			
			int lastTime = users[N-1];
			Queue<Integer> queue = new LinkedList<>();
			
			int time = M;
			while(time <= lastTime) {
				for(int i = 0; i < K; i++) {
					queue.offer(time);
				}
				time += M;
			}
			
			boolean isTrue = true;
			for(int i = 0; i < N; i++) {
				if(queue.isEmpty()) {
					isTrue = false;
					break;
				}
				int bread = queue.poll();
				if(users[i] < bread) {
					isTrue = false;
					break;
				}
			}
			
			if(isTrue) {
				System.out.println("#"+testCase+" "+"Possible");
			}else {
				System.out.println("#"+testCase+" "+"Impossible");
			}
			
			
		}
	}
}
