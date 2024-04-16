import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        answer[0] = arr[0];
        int lastIndex = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] > answer[lastIndex - 1]) {
                answer[lastIndex] = arr[i];
                lastIndex++;
            } else {
                int left = 0;
                int right = lastIndex;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (arr[i] > answer[mid]) {
                        left = mid + 1;
                    } else { //arr[i] >= arr[mid]
                        right = mid;
                    }
                }

                answer[left] = arr[i];
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (answer[i] == 0) {
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
