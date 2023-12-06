import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        int[] basket = new int[2];
        basket[0] = 3;
        basket[1] = 5;
        
        array = new int[N+1];
        Arrays.fill(array, Integer.MAX_VALUE);
        array[0] = 0;
        
        for(int i = 0; i<2; i++){
            for(int j = basket[i]; j<=N; j++){
                if(array[j - basket[i]] != Integer.MAX_VALUE){
                    array[j] = Math.min(array[j], array[j - basket[i]]+1);
                }
            }
        }
        if(array[N] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(array[N]);
        }
        
      
    }
}
