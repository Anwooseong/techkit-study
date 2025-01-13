import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            String line = bf.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                char word = line.charAt(i);
                if (word == '<') {
                    if (!left.isEmpty()) right.push(left.pop());
                } else if (word == '>') {
                    if (!right.isEmpty()) left.push(right.pop());
                } else if (word == '-') {
                    if (!left.isEmpty()) left.pop();
                } else {
                    left.push(word);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            System.out.println(sb);
        }
    }
}
