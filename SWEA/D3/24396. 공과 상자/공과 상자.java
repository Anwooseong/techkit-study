import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, B, W, X, Y, Z;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			
			B = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			Z = Integer.parseInt(st.nextToken());
			
			long maxScore;

            if (X + Y >= 2 * Z) {
                maxScore = B * X + W * Y;
            } else {
                maxScore = Math.max(0L, B - W) * X + Math.max(0L, W - B) * Y + 2L * Math.min(B, W) * Z;
            }

			System.out.println(maxScore);
		}
	}
}