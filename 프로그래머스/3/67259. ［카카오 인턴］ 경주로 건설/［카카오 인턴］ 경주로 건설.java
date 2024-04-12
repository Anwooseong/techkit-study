class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};   
    //동 서 북 남
    
    static int[][] check;
    
    static int answer;
    static int n;
    
    public int solution(int[][] board) {
        
        n = board.length;
        check = new int[n][n];
        answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                check[i][j] = Integer.MAX_VALUE;
            }
        }
        
        //dfs - 움직인 방향, 직선 갯수, 코너 갯수, 움직인 곳의 x, y 좌표
        check[0][0] = 0;
        if(board[0][1] == 0){
            check[0][1] = 100;
            dfs(board, 0, 1, 0, 0, 1); //동쪽이동
        }
        if(board[1][0] == 0){
            check[1][0] = 100;
            dfs(board, 3, 1, 0, 1, 0); //남쪽이동
        }
        
        return answer;
    }
    
    void dfs(int[][] board, int moveDirection, int directCnt, int cornerCnt, int x, int y){
        
        if(answer <= directCnt*100 + cornerCnt*500){
            return;
        }
        
        if(x == (n-1) && y == (n-1)){
            answer = Math.min(answer, directCnt*100 + cornerCnt*500);
            return;
        }
        
        //dfs - 움직인 방향, 직선 갯수, 코너 갯수, 움직인 곳의 x, y 좌표
        //동 서 북 남(0/1  -  2/3)
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n){
                if(board[nextX][nextY] == 0){
                    if(moveDirection == i){
                        if(check[nextX][nextY] >= (directCnt+1)*100 + cornerCnt*500 - 400){
                            check[nextX][nextY] = (directCnt+1)*100 + cornerCnt*500; 
                            dfs(board, i, directCnt + 1, cornerCnt, nextX, nextY);
                        }
                    }else{
                        if(check[nextX][nextY] >= (directCnt+1)*100 + (cornerCnt+1)*500 - 400){
                            check[nextX][nextY] = (directCnt+1)*100 + (cornerCnt+1)*500;
                            dfs(board, i, directCnt + 1, cornerCnt + 1, nextX, nextY);
                        }
                    }
                }
            }
        }
    }
}