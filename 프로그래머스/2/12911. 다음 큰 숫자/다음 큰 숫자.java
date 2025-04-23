import java.util.*;

class Solution {
    public int solution(int n) {
        // int binaryOneCnt = countByNum(n);
        int binaryOneCnt = Integer.bitCount(n);
        int num = n + 1;
        
        while(true){
            // int cnt = countByNum(num);
            int cnt = Integer.bitCount(num);
            if(binaryOneCnt == cnt) break;
            num++;
        }
        
        return num;
    }
    
    private int countByNum(int num){
        int cnt = 0;
        
        while(true){
            int divNum = num % 2;
            num /= 2;
            if(divNum == 1) cnt++;
            if(num == 0) break;
        }
        return cnt;
    }
}