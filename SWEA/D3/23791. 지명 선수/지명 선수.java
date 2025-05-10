import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N;
	static String[] arr;
	static Queue<Integer> Aqueue, Bqueue;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			init(bf);
			arr = new String[N+1];
			char turn = 'A';
			
			for(int i = 1; i <= N; i++) {
				if(turn == 'A') {
					while(!Aqueue.isEmpty() && arr[Aqueue.peek()] != null) {
						Aqueue.poll();
					}
					
					if(!Aqueue.isEmpty()) {
						arr[Aqueue.poll()] = "A";
					}
					
					turn = 'B';
					
				}else {
					while(!Bqueue.isEmpty() && arr[Bqueue.peek()] != null) {
						Bqueue.poll();
					}
					
					if(!Bqueue.isEmpty()) {
						arr[Bqueue.poll()] = "B";						
					}
					
					turn = 'A';
				}
			}
			
			for(int i = 1; i <= N; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}

	private static void init(BufferedReader bf) throws IOException {
		StringTokenizer st;
		Aqueue = new LinkedList<>();
		Bqueue = new LinkedList<>();
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			Aqueue.offer(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			Bqueue.offer(Integer.parseInt(st.nextToken()));
		}
	}
}

	