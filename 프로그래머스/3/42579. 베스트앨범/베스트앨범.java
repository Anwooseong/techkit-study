import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> num = new HashMap<>(); //음악, 총 조회수
        Map<String, Map<Integer, Integer>> music = new HashMap<>(); //음악, <인덱스, 조회수>
        
        for(int i = 0; i < genres.length; i++){
            if(!num.containsKey(genres[i])){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]); //play인덱스, 조회수
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            }else{
                music.get(genres[i]).put(i, plays[i]);
                num.put(genres[i], num.get(genres[i]) + plays[i]);
            }
        }
        
        List<String> keys = new ArrayList(num.keySet());
        Collections.sort(keys, (m1, m2) -> num.get(m2) - num.get(m1));
        
        for(String key : keys){
            List<Integer> indexes = new ArrayList(music.get(key).keySet()); //인덱스
            Collections.sort(indexes, (m1, m2) -> music.get(key).get(m2) - music.get(key).get(m1));
            
            if(indexes.size() > 1){
                answer.add(indexes.get(0));
                answer.add(indexes.get(1));
            }else{
                answer.add(indexes.get(0));
            }
        }
        
        int[] answerArray = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            answerArray[i] = answer.get(i);
        }
        
        return answerArray;
    }
}