class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // for(int i = 0 ; i < computers.length; i++){
        //     for(int j = 0; j < computers[i].length; j++){
        //         System.out.print(computers[i][j]);
        //     }
        //     System.out.println();
        // }
        
        for(int i = 0 ; i < computers.length - 1; i++) {
            for(int j = i + 1; j < computers[i].length; j++){
                if(computers[i][j] == 1){
                    System.out.println(""+i+" - "+j);
                    answer ++;
                }
            }
        }
        return answer;
    }
}