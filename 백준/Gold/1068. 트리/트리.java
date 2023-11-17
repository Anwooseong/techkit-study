import java.util.*;

public class Main {

    static int N, deleteNum;
    static Map<Integer, List<Integer>> map;
    static int cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        map = new HashMap<>();
        cnt = 0;

        for (int i = 0; i < N; i++) {
            int parentNode = scanner.nextInt();
            if (!map.containsKey(parentNode)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(parentNode, list);
            } else {
                map.get(parentNode).add(i);
            }
        }
        scanner.nextLine();
        deleteNum = scanner.nextInt();


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(-1);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (!map.containsKey(poll)) {
                cnt++;
                continue;
            }
            List<Integer> getValues = map.get(poll);
            for (Integer getValue : getValues) {
                if (deleteNum == getValue) {
                    if (getValues.size() == 1) {
                        if (poll != -1)
                            cnt++;
                    }
                    continue;
                }
                queue.offer(getValue);
            }
        }


        System.out.println(cnt);

    }
}
