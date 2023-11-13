import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            int count = scanner.nextInt();
            scanner.nextLine();

            if (count == 0) {
                System.out.println(0);
                continue;
            }
            Map<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < count; j++) {
                String[] cloth = scanner.nextLine().split(" ");
                clothes.put(cloth[1], clothes.getOrDefault(cloth[1], 0) + 1);
            }

            int sum = 1;
            for (String clothesCount : clothes.keySet()) {
                sum *= (clothes.get(clothesCount) + 1);
            }
            System.out.println(sum-1);
        }
    }
}
