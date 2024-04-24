import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int money = Integer.parseInt(bf.readLine());
			
			int oneMoney = money / 50000;
			money = money % 50000;
			
			int twoMoney = money / 10000;
			money = money % 10000;
			
			int threeMoney = money / 5000;
			money = money % 5000;
			
			int fourMoney = money / 1000;
			money = money % 1000;
			
			int fiveMoney = money / 500;
			money = money % 500;
			
			int sixMoney = money / 100;
			money = money % 100;
			
			int sevenMoney = money / 50;
			money = money % 50;
			
			int eightMoney = money / 10;
			money = money % 10;
			
			System.out.println("#"+test_case);
			System.out.println(oneMoney+" "+twoMoney+" "+threeMoney+" "+fourMoney+" "+fiveMoney+" "+sixMoney+" "+sevenMoney+" "+eightMoney);
		}
		
	}

}
