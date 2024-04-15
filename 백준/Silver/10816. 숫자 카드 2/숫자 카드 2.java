import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(bf.readLine());
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        List<Integer> list = new ArrayList(map.keySet());
        Collections.sort(list); // -10 2 3 6 10

        int M = Integer.parseInt(bf.readLine());
        String problemLine = bf.readLine();
        StringTokenizer token = new StringTokenizer(problemLine);
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(token.nextToken());

            int left = 0;
            int right = list.size() - 1;
            boolean isCheck = false;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (list.get(mid) == num) {
                    isCheck = true;
                    bw.write(map.get(num) + " ");
                    break;
                } else if (list.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (!isCheck) {
                bw.write("0 ");
            }

        }

        bw.flush();
        bw.close();
    }
}
