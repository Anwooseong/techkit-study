class Solution {
    
    static boolean[] check;
    static int answer;
    
    public int solution(int n, int[][] computers) {
        
        check = new boolean[n];
        answer = 0;
        
        for(int i = 0; i < n; i++){
            if(!check[i]){
                dfs(computers, i);
                answer++;                
            }
        }
        
        
        return answer;
    }
    
    void dfs(int[][] computers, int row){
        check[row] = true;
        
        for(int i = 0; i < computers[row].length; i++){
            if(row != i && computers[row][i] == 1 && !check[i]){
                dfs(computers, i);
            }
        }
        
        
    }
    
}