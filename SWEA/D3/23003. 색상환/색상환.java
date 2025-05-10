import java.io.*;
import java.util.*;

public class Solution {
	
	static int T;
	static String[] arr = {"red", "orange", "yellow", "green", "blue", "purple"};
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new HashMap<>();
		map.put("red", 0);
		map.put("orange", 1);
		map.put("yellow", 2);
		map.put("green", 3);
		map.put("blue", 4);
		map.put("purple", 5);
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			String left = st.nextToken();
			String right = st.nextToken();
			//같은 것일때는 -> 인덱스가 같은지
			//반대일때는 -> 0/3 - 1/4 - 2/5 (인덱스 + 3) % 6
			//인접일때는 -> 0(1,5) - 1(0,2) - 2(1,3) - 3(2,4) - 4(3,5) - 5(4,0) 
			//			-> 왼쪽은 ( 6 + 인덱스 - 1) % 6, 오른쪽은(인덱스 + 1) % 6
			
			int idx = map.get(left);
			if(isMatch(idx, right)) {
				System.out.println("E");
			}else if(isNext(idx, right)) {
				System.out.println("A");
			}else if(isOppsite(idx, right)) {
				System.out.println("C");
			}else {
				System.out.println("X");
			}
		}
	}
	
	private static boolean isOppsite(int idx, String right) {
		return arr[(idx + 3) % 6].equals(right);
	}

	private static boolean isNext(int idx, String right) {
		return arr[(6 + idx - 1) % 6].equals(right) || arr[(idx + 1) % 6].equals(right);
	}

	private static boolean isMatch(int idx, String right) {
		return arr[idx].equals(right);
	}
}

	