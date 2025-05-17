import java.io.*;
import java.util.*;

public class Main {
	
	static int X, Y, left, right, originAvg;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		originAvg = calculateAvg(X, Y);
		
		left = 0;
		right = 1000000000;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			int avg = calculateAvg(X + mid, Y + mid);
			if(originAvg < avg) {
				right = mid - 1;
			}else if(originAvg >= avg) {
				left = mid + 1;
			}
		}
		
		System.out.println(left == 1000000001 ? -1 : left);
	}
	
	private static int calculateAvg(long x, long y) {
		return (int)((y * 100) / x);
	}
}