import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        int sum = 0;
        int cnt = 1;
        for(int i = 0; i < d.length; i++){
            sum += d[i];
            if(sum > budget){
                break;
            }
            answer = Math.max(answer, cnt);
            cnt++;
        }
        
        return answer;
    }
    
}