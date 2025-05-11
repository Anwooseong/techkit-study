import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, len, start;
	static int[][] arr;
	static boolean[] visited;
	static Queue<Integer> queue;
	static List<Integer> answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = 10;
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			queue = new LinkedList<>();
			answer = new ArrayList<>();
			
			arr = new int[101][101];
			visited = new boolean[101];
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < len/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				arr[from][to] = 1;
			}
			
			bfs();
			
			System.out.println("#"+testCase+" "+answer.get(answer.size()-2));
		}
	}

	private static void bfs() {
		queue.offer(start);
		visited[start] = true;
		int max = 0;
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			max = 0;
			
			for(int i = 0; i < queueSize; i++) {
				int poll = queue.poll();
				
				for(int j = 0; j < 101; j++) {
					if(arr[poll][j] == 1 && !visited[j]) {
						queue.offer(j);
						visited[j] = true;
						max = Math.max(max, j);
					}
				}
			}
			
			answer.add(max);
		}
	}
}

	