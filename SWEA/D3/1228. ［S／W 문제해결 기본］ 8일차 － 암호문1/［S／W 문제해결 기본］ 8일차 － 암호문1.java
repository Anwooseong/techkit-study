import java.io.*;
import java.util.*;

public class Solution {
	
	static int T;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = 10;
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(bf.readLine());
			String[] line = bf.readLine().split(" ");
			List<String> list = new ArrayList<>();
			for(String word : line) {
				list.add(word);
			}
			
			int cmd = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < cmd; i++) {
				if(st.nextToken().equals("I")) {
					int idx = Integer.parseInt(st.nextToken());
					int repeatCnt = Integer.parseInt(st.nextToken());
					for(int j = 0; j < repeatCnt; j++) {
						list.add(idx, st.nextToken());
						idx++;
					}
				}
			}
			
			System.out.print("#"+testCase+" ");
			for(int i = 0; i < 10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
		
		
	}
}

	