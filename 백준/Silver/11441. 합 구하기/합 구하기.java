import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine(), " ");
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            System.out.println(arr[finish] - arr[start - 1]);
        }
    }
}