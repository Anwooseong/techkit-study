import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        
        int zeroCnt = 0;
        int binaryCnt = 0;
        int[] answer = new int[2];
        
        while(s.length()>1) {
            
            for(int i = 0; i < s.length(); i++){ //0제거 제거된 0갯수 보관
                
                int originLength = s.length();
                String noZeroString = s.replace("0", ""); //0제거
                int noZeroStringLength = noZeroString.length();
                int deleteZeroCnt = originLength - noZeroStringLength; //제거된 0갯수
                zeroCnt += deleteZeroCnt; //제거된 0갯수 보관
                
                //0제거된 길이를 이진수로 변환
                List<Integer> numList = new ArrayList<>();
                while (noZeroStringLength > 0){
                    numList.add(noZeroStringLength % 2);
                    noZeroStringLength = noZeroStringLength / 2;
                }
                
                StringBuilder sb = new StringBuilder();
                for(int j = numList.size() - 1; j >= 0; j--){
                    sb.append(numList.get(j));
                }
                s = sb.toString();
                binaryCnt++;
            }
        }
        
        answer[0] = binaryCnt;
        answer[1] = zeroCnt;
        
        return answer;
    }
}