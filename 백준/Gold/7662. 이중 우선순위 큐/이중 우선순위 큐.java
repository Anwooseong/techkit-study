import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= T; testCase++) {
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> priorityMaxQueue = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> priorityMinQueue = new PriorityQueue<>();

            int N = Integer.parseInt(bf.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine(), " ");
                String word = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (word.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    priorityMaxQueue.offer(num);
                    priorityMinQueue.offer(num);
                } else if (word.equals("D")) {
                    if (num == -1) {
                        while (!priorityMinQueue.isEmpty()) {
                            int poll = priorityMinQueue.poll();
                            if (map.containsKey(poll)) {
                                int count = map.get(poll);
                                if (count == 1) {
                                    map.remove(poll);
                                } else {
                                    map.put(poll, count - 1);
                                }
                                break;
                            }
                        }
                    } else if (num == 1) {
                        while (!priorityMaxQueue.isEmpty()) {
                            int poll = priorityMaxQueue.poll();
                            if (map.containsKey(poll)) {
                                int count = map.get(poll);
                                if (count == 1) {
                                    map.remove(poll);
                                } else {
                                    map.put(poll, count - 1);
                                }
                                break;
                            }
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                while (!priorityMaxQueue.isEmpty()) {
                    int max = priorityMaxQueue.peek();
                    if (map.containsKey(max)) {
                        sb.append(max).append(" ");
                        break;
                    } else {
                        priorityMaxQueue.poll();
                    }
                }
                while (!priorityMinQueue.isEmpty()) {
                    int min = priorityMinQueue.peek();
                    if (map.containsKey(min)) {
                        sb.append(min).append("\n");
                        break;
                    } else {
                        priorityMinQueue.poll();
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
