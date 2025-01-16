class Solution {
    public int solution(int[] stones, int k) {
        int min = 0;
        int max = 200000000;
        
        int answer = 0;
        while(min <= max){
            int mid = (min + max) / 2;
            
            boolean isFlag = true;
            int cnt = 0;
            for(int stone : stones){
                if(stone - mid < 0) cnt++;
                else cnt = 0;
                if(cnt == k){
                    isFlag = false;
                    break;
                }
            }
            if(isFlag){ //건널수있음
                min = mid + 1;
                answer = Math.max(answer, mid);
            }else{
                max = mid - 1;
            }
        }
        return answer;
    }
}