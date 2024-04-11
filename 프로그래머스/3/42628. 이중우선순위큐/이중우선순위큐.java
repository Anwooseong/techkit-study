import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        
        int[] answer = new int[2];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>((m1,m2) -> m2-m1);
        
        for(String operation : operations){
            String[] line = operation.split(" ");
            String cmd = line[0];
            int num = Integer.parseInt(line[1]);
            
            if(cmd.equals("I")){
                queue.offer(num);
                reverseQueue.offer(num);
            }else if(!queue.isEmpty() && cmd.equals("D")){
                if(num == 1){ //큐에서 최댓값제거
                    Integer maxNum = reverseQueue.poll();
                    queue.remove(maxNum);
                }else if(num == -1){
                    Integer minNum = queue.poll();
                    reverseQueue.remove(minNum);
                }
            }
        }
        
        answer[0] = reverseQueue.isEmpty() ? 0 : reverseQueue.poll();
        answer[1] = queue.isEmpty() ? 0 : queue.poll();
        return answer;
    }
}