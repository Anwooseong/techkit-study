class Solution {
    int[] dp;
    public int solution(int sticker[]) {
        int answer = 0;

        int N = sticker.length;

        if(N == 1)return sticker[0];
        if(N == 2)return Math.max(sticker[0], sticker[1]);
        dp = new int[N];
        dp[0] = dp[1] = sticker[0];
        for(int i = 2; i < N; i++){
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
        }
        int firstAnswer = dp[N-2];
        
        dp = new int[N];
        dp[1] = sticker[1];
        for(int i = 2; i < N; i++){
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
        }
        int secondAnswer = dp[N-1];
        
        
        return Math.max(firstAnswer, secondAnswer);
    }
}