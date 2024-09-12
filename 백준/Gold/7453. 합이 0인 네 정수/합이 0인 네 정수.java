import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[n * n];
        int[] CD = new int[n * n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int left = 0;
        int right = n * n - 1;
        long answer = 0;
        while (left < n * n && right >= 0) {
            if (AB[left] + CD[right] > 0) {
                right--;
            } else if (AB[left] + CD[right] < 0) {
                left++;
            } else {
                long leftCount = 1;
                long rightCount = 1;
                while (left + 1 < n * n && (AB[left] == AB[left + 1])) {
                    leftCount++;
                    left++;
                }
                while (right - 1 >= 0 && (CD[right] == CD[right - 1])) {
                    rightCount++;
                    right--;
                }
                answer += (leftCount * rightCount);
                right--;
            }
        }
        System.out.println(answer);
    }
}