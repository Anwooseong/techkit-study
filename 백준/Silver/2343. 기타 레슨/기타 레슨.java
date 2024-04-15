import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int start = 0;
        int finish = 0;
        int mid = 0;
        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            start = Math.max(start, num);
            finish += num;
        }

        while (start < finish) {
            mid = (start + finish) / 2;

            int count = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += arr[i];

                if (sum == mid) {
                    sum = 0;
                    count++;
                } else if (sum > mid) {
                    sum = arr[i];
                    count++;

                } else if (i == N - 1) {
                    sum = 0;
                    count++;
                }
            }
            if (sum > 0) {
                sum = 0;
                count++;
            }

            if (count <= M) {
                finish = mid;
            } else {
                start = mid+1;
            }

        }
        System.out.println(start);


    }
}
