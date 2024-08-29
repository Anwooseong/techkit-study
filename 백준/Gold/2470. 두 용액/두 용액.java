import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                answer[0] = arr[left];
                answer[1] = arr[right];
                min = Math.abs(sum);
            }
            if (sum == 0) break;
            if(sum < 0) left++;
            else right--;
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}