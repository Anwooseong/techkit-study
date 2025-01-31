import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 1; i < line.length() - 1; i++) {
            for (int j = i + 1; j < line.length(); j++) {
                StringBuilder sb = new StringBuilder();

                String range1 = reverse(line.substring(0, i));
                String range2 = reverse(line.substring(i, j));
                String range3 = reverse(line.substring(j));

                sb.append(range1).append(range2).append(range3);

                pq.offer(sb.toString());
            }
        }
        System.out.println(pq.poll());
    }

    private static String reverse(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}