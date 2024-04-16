import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] road = new int[N + 2];
        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 1; i < N + 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        road[N + 1] = L;
        Arrays.sort(road);

        int left = 1;
        int right = L - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for (int i = 1; i < N + 2; i++) {
                sum += (road[i] - road[i - 1] - 1) / mid;
                if (sum > M) {
                    break;
                }
            }

            if (sum <= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
