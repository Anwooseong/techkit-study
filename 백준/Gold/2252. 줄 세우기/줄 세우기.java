import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int[] arr = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            list.get(front).add(back);
            arr[back]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            System.out.print(poll+ " ");
            List<Integer> pollList = list.get(poll);
            for (int i = 0; i < pollList.size(); i++) {
                int num = pollList.get(i);
                arr[num]--;
                if (arr[num] == 0) queue.offer(num);
            }
        }
    }
}
