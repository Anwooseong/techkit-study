import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(bf.readLine());
			Map<Integer, Integer> totalMap = new HashMap<Integer, Integer>();
			int[] arr = new int[N*2];
			
			st = new StringTokenizer(bf.readLine(), " ");
			for(int i = 0; i < N*2; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;
				totalMap.put(num, totalMap.getOrDefault(num, 0)+1);
			}
			
			List<Integer> list = new ArrayList<Integer>();
			for(int i = N*2-1; i >= 0; i--) {
				int price = arr[i];
				int discountPrice = (int) (price * 0.75);
				if(totalMap.get(price) >= 1 && totalMap.get(discountPrice) >= 1) {
					totalMap.put(price, totalMap.get(price)-1);
					totalMap.put(discountPrice, totalMap.get(discountPrice)-1);
					list.add(discountPrice);
				}
			}
			
			System.out.print("#"+testCase);
			for(int i = list.size()-1; i >= 0; i--) {
				System.out.print(" "+list.get(i));
			}
			System.out.println();
		}
	}
}










