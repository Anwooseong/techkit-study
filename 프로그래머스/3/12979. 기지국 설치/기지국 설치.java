class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int finishPoint = 1;
        
        for(int i = 0; i < stations.length; i++){
            if((stations[i]-w) > finishPoint){
                int cnt = (stations[i]-w-finishPoint)/(2*w+1);
                if((stations[i]-w-finishPoint)%(2*w+1) != 0){
                    cnt++;
                }
                answer += cnt;
            }
            finishPoint = stations[i]+w+1;
        }
        
        if(n > (stations[stations.length-1]+w)){
            int cnt = (n - (stations[stations.length-1]+w))/(2*w+1);
            if((n - (stations[stations.length-1]+w))%(2*w+1) != 0){
                cnt++;
            }
            answer += cnt;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        return answer;
    }
}