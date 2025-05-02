import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N;
	static Map<Character, Character> map;
	static {
        map = new HashMap<Character, Character>(); // HashMap 객체 생성
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        map.put('>', '<');
    }
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		T = 10;
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			String line = bf.readLine();
			Stack<Character> stack = new Stack<Character>();
			boolean isValid = true;
			
			for(int i = 0; i < N; i++) {
				char character = line.charAt(i);
				if(!map.containsKey(character)) {
					stack.add(character);
				}else {
					if(!stack.isEmpty()) {
						char peek = stack.peek();
						if(map.get(character) == peek) {
							stack.pop();
						}else {
							isValid = false;
							break;
						}
					}else {
						isValid = false;
						break;
					}
				}
			}
			if(isValid && stack.isEmpty()) {
				System.out.println("#"+testCase+" 1");
			}else {
				System.out.println("#"+testCase+" 0");
			}
		}
	}
}