class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        //지도 설정
        int[][] map = new int[n+1][m+1];
        
        for(int[] puddle : puddles){
            // System.out.println(puddle[0]);
            // System.out.println(puddle[1]);
            map[puddle[1]][puddle[0]] = -1;
        }
        
        if(map[1][2] != -1){
            map[1][2] = 1;
        }
        
        if(map[2][1] != -1){
            map[2][1] = 1;
        }
        
        // for(int[] line : map){
        //     for(int num : line){
        //         System.out.print(num+" ");
        //     }
        //     System.out.println();
        // }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                
                if((i==2 && j==1) || (i==1 && j==2) || map[i][j] == -1){
                    continue;
                }
            
                if(map[i-1][j] == -1 && map[i][j-1] == -1){
                    map[i][j] = 0;
                } else if(map[i-1][j] == -1){
                    map[i][j] = map[i][j-1] % 1000000007;
                } else if(map[i][j-1] == -1){
                    map[i][j] = map[i-1][j] % 1000000007;
                } else{
                    map[i][j] = (map[i][j-1] + map[i-1][j]) % 1000000007;
                }
            }
        }
        
        return map[n][m] % 1000000007;
    }
}