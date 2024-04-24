import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		StringTokenizer st;
		StringBuilder sb;
		for(int testCase = 1; testCase<=T; testCase++) {
			sb = new StringBuilder();
			int N = Integer.parseInt(bf.readLine());

			System.out.println("#"+testCase); 
			
			int lineCnt = 0;
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				String alphabet = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				for(int j = 1; j<=num; j++) {
					sb.append(alphabet);
					lineCnt++;
					if(lineCnt % 10 == 0) {
						sb.append('\n');
					}
				}
			}
			
			System.out.println(sb.toString());
		}
	}
}
