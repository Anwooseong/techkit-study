import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (m1,m2) -> m1[1] - m2[1]);
        
        int finishPoint = routes[0][1];
        answer++;
        
        for(int i = 1; i < routes.length; i++){
            if(routes[i][0] > finishPoint){
                finishPoint = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}