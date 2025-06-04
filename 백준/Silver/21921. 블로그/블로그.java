import java.io.*;
import java.util.*;

public class Main {
	
	static int N, X, maxPerson, cnt;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N];
		maxPerson = 0;
		cnt = 0;
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int tmp = 0;
		for(int i = 0; i < X; i++) {
			tmp += arr[i];
		}
		
		changeMaxCnt(tmp);
		
		for(int i = X; i < N; i++) {
			int removeIdx = i - X;
			tmp -= arr[removeIdx];
			tmp += arr[i];
			changeMaxCnt(tmp);
		}
		
		if(maxPerson == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(maxPerson);
			System.out.println(cnt);
		}
	}
	
	static private void changeMaxCnt(int tmp) {
		if(maxPerson == 0 && tmp == 0) {
			cnt = 0;
		}else if(maxPerson == tmp) {
			cnt++;
			maxPerson = tmp;
		}else if(maxPerson < tmp) {
			cnt = 1;
			maxPerson = tmp;
		}
	}
}
