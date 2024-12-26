import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> priorityMaxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> priorityMinQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (priorityMaxQueue.isEmpty()) {
                priorityMaxQueue.offer(num);
            } else if (priorityMinQueue.isEmpty()) {
                if (num < priorityMaxQueue.peek()) {
                    Integer poll = priorityMaxQueue.poll();
                    priorityMinQueue.offer(poll);
                    priorityMaxQueue.offer(num);
                } else {
                    priorityMinQueue.offer(num);
                }
            } else {
                if (priorityMaxQueue.size() == priorityMinQueue.size()) {
                    if (num < priorityMinQueue.peek()) {
                        priorityMaxQueue.offer(num);
                    } else {
                        Integer poll = priorityMinQueue.poll();
                        priorityMaxQueue.offer(poll);
                        priorityMinQueue.offer(num);
                    }
                } else if (priorityMaxQueue.size() > priorityMinQueue.size()) {
                    if (num < priorityMaxQueue.peek()) {
                        Integer poll = priorityMaxQueue.poll();
                        priorityMinQueue.offer(poll);
                        priorityMaxQueue.offer(num);
                    } else { //num >= priorityMaxQueue.peek()
                        priorityMinQueue.offer(num);
                    }
                }
            }
            System.out.println(priorityMaxQueue.peek());
        }
    }
}
