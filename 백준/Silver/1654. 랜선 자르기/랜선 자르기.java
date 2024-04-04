import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] stick = new int[K];
		
		int maxValue = Integer.MIN_VALUE;
		for(int i = 0; i < K; i++) {
			stick[i] = Integer.parseInt(br.readLine());
			maxValue = Math.max(maxValue, stick[i]);
		}
		
		
		//이진수 구해서 각각 나눠서 갯수 구하기
		//갯수가 넘쳐나 줄이고
		//갯수가 부족하면 늘리
		long low = 1;
		long high = maxValue;
		long result = 0;
		while(low <= high) {
			long mid = (low + high) / 2;
			
			long cnt = 0;
			for(int i = 0; i < K; i++) {
				cnt += stick[i] / mid;
			}
			
//			bw.write(Integer.toString(cnt));
//			bw.newLine();
			
			if(cnt < N) { //막대기 크기를 줄여야
				high = mid - 1;
			}else {
				low = mid + 1;
				if(mid >= result) {
					result = mid;
				}
			}
			
		}
		
		bw.write(Long.toString(result));
		
		bw.flush();
		bw.close();
	}

}
