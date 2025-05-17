import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int[] regions = new int[N];
        long min = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            regions[i] = Integer.parseInt(st.nextToken());
            max = Math.max(regions[i] + 1, max);
        }
        int M = Integer.parseInt(bf.readLine());

        while (min < max) {
            long mid = (min + max) / 2;
            long cnt = 0;
            for (int region : regions) {
                cnt = region < mid ? cnt + region : cnt + mid;
            }

            if (cnt > M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}