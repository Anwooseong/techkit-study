import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {

    static BigDecimal multi;
    static int n, m;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        multi = new BigDecimal(100);

        while (true) {
            st = new StringTokenizer(bf.readLine());

            n = Integer.parseInt(st.nextToken());
            m = new BigDecimal(st.nextToken()).multiply(multi).intValue();

            if (n == 0 && m == 0) break;
            dp = new int[m + 1];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                int calorie = Integer.parseInt(st.nextToken());
                int price = new BigDecimal(st.nextToken()).multiply(multi).intValue();

                for (int j = 0; j <= m; j++) {
                    if (j - price >= 0) dp[j] = Math.max(dp[j], dp[j-price] + calorie);
                }
            }

            System.out.println(dp[m]);

        }
    }
}