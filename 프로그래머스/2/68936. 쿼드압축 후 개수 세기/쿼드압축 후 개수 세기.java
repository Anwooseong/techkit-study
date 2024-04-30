import java.util.*;
import java.io.*;

class Solution {
    
    Map<Integer,Integer> map;
    public int[] solution(int[][] arr) {
        map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        int N = arr.length;
        //행 범위, 열 범위
        dfs(0, 0, N, arr);
        
        int[] answer = new int[2];
        answer[0] = map.get(0);
        answer[1] = map.get(1);
        return answer;
    }
    
    void dfs(int startX, int startY, int len, int[][] arr){
        //0, 2, 0, 2
        if(len == 0){
            //추가
            map.put(arr[startX][startY], map.get(arr[startX][startY])+1);
            return;
        }
        
        boolean isTrue = true;
        int originNum = arr[startX][startY];
        for(int i = startX; i < startX + len; i++){
            for(int j = startY; j < startY + len; j++){
                if(originNum != arr[i][j]){
                    isTrue = false;
                    break;
                }
            }
            if(!isTrue){
                break;
            }
        }
        
        if(isTrue){
            //추가
            map.put(arr[startX][startY], map.get(arr[startX][startY])+1);
        }else{
            //4등분
            dfs(startX, startY, len/2, arr);
            dfs(startX, startY + len/2, len/2, arr);
            dfs(startX + len/2, startY, len/2, arr);
            dfs(startX + len/2, startY + len/2, len/2, arr);
        }
        
        
        
        
        
    }
}