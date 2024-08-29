import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(bf.readLine(), " ");
        long min = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max((long) trees[i] + 1, max);
        }

        long answer = binarySearch(trees, min, max, M);
        System.out.println(answer);
    }

    static long binarySearch(int[] trees, long min, long max, int M) {
        while (min < max) {
            long mid = (min + max) / 2;
            if (count(trees, mid) < M) { //자를 높이를 낮춰야하므로 상한선을 내려야된 max를 내려야됨
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min - 1;
    }

    static long count(int[] trees, long mid) {
        long cnt = 0;
        for (int tree : trees) {
            if (tree - mid > 0) {
                cnt += (tree - mid);
            }
        }
        return cnt;
    }
}