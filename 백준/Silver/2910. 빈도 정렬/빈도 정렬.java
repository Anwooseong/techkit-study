import java.util.*;

public class Main {

    static int N, C;
    static Map<Integer, Integer> numsMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        C = scanner.nextInt();
        scanner.nextLine();
        numsMap = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            numsMap.put(n, numsMap.getOrDefault(n, 0) + 1);
        }
        scanner.nextLine();

        List<Integer> keys = new ArrayList<>(numsMap.keySet());
        Collections.sort(keys, (v2, v1) ->
                (numsMap.get(v1).compareTo(numsMap.get(v2))));

        for (Integer key : keys) {
            for (int i = 0; i < numsMap.get(key); i++) {
                System.out.print("" + key+" ");
            }
        }

    }
}
