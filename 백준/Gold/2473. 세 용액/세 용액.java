import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long answer = Long.MAX_VALUE;
        int[] answerArr = new int[3];

        for (int i = 0; i <= N - 3; i++) {
            int start = i;
            int mid = i + 1;
            int end = N - 1;
            while (mid < end) {
                long sum = arr[start] + arr[mid] + arr[end];
                if (answer > Math.abs(sum)) {
                    answer = Math.abs(sum);
                    answerArr[0] = start;
                    answerArr[1] = mid;
                    answerArr[2] = end;
                }
                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    mid++;
                } else {
                    break;
                }
            }
        }
        System.out.println(arr[answerArr[0]] + " " + arr[answerArr[1]] + " " + arr[answerArr[2]]);
    }
}