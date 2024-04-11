class Solution {
    
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        
        answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < words.length; i++){
            boolean[] check = new boolean[words.length];
            if(changeTrue(begin, words[i])){
                // check[i] = true;
                dfs(words, begin, i, check, target, 0);
                // check[i] = false;
            }
        }
        
        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        
        
        return answer;
    }
    
    void dfs(String[] words, String originWord, int position, boolean[] check, String target, int cnt){
        if(originWord.equals(target)){
            answer = Math.min(cnt, answer);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(changeTrue(originWord, words[i]) && !check[i]){
                check[position] = true;
                dfs(words, words[i], i, check, target, cnt+1);
                check[position] = false;
            }
        }
    }
    
    boolean changeTrue(String originWord, String changeWord){
        
        int cnt = 0;
        
        for(int i = 0; i < originWord.length(); i++){
            if(originWord.charAt(i) != changeWord.charAt(i)){
                cnt++;
                if(cnt > 1) break;
            }
        }
        
        if(cnt == 1){
            return true;
        }else{
            return false;
        }
    }
}