import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] nums;
    static int x;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        x = sc.nextInt();
        answer = 0;


        Arrays.sort(nums);

        int left=0, right = n-1;
        while(left < right){
            int sum = nums[left]+nums[right];
            if(sum == x){
                answer++;
                left++;
                right--;
            } else if (sum > x) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer);
    }
}
