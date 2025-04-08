import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long[] stores;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        stores = new long[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            char s = st.nextToken().charAt(0);
            long a = Long.parseLong(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            graph[p].add(i);
            stores[i] = s == 'S' ? a : -a;
        }

        dfs(1, -1);
        System.out.println(stores[1]);
    }

    static void dfs(int start, int next) {
        for (int i = 0; i < graph[start].size(); i++) {
            int v = graph[start].get(i);
            dfs(v, start);
        }

        if (next != -1) {
            if (stores[start] > 0) {
                stores[next] += stores[start];
            }
        }
    }
}
