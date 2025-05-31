import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static long[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		if(N == 1 || N== 2) {
			System.out.println(1);
		}else if(N == 0) {
			System.out.println(0);
		}else {
			arr = new long[N+1];
			arr[1] = 1;
			arr[2] = 1;
			for(int i = 3; i <= N; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
			System.out.println(arr[N]);
		}
	}
}
