import java.io.*;
import java.util.*;

public class Main {
	//주전가 용량은 같지만, 막걸리 용량은 random
	//N주전자 주문, K명에게 똑같이 막걸리 나눠줌
	//은상과 친구들은 조금이라도 막걸리 남아있으면 버림(함수로 처리)
	//K명에게 최대한 많은 양의 막걸리를 분배할 수 있는 용량 ml(binarySearch)
	
	static int N, K;
	static long left, right;
	static int[] kettles;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		kettles = new int[N];
		left = 1;
		right = 1;
		for(int i = 0; i < N; i++) {
			kettles[i] = Integer.parseInt(bf.readLine());
			right = Math.max(right, kettles[i]);
		}
		//upper bound
		while(left <= right) {
			long mid = (left + right) / 2;
			
			long cnt = calculate(mid);
			if(cnt < K) { // 술 나눠주는 사람이 K명 보다 적으면 용량을 줄여야됨 right = mid - 1;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		System.out.println(right);
	}
	
	private static long calculate(long num) {
		long cnt = 0;
		for(int i = 0; i < N; i++) {
			int kettle = kettles[i];
			cnt += kettle / num;
		}
		return cnt;
	}
}


