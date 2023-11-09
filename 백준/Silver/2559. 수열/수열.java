import java.util.Scanner;

public class Main {
    static int max_value = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine();

        int[] temperatureArray = new int[N];
        for (int i = 0; i < N; i++) {
            temperatureArray[i] = scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 0; i < N - K + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + K; j++) {
                sum += temperatureArray[j];
            }
            max_value = Math.max(max_value, sum);
        }
        System.out.println(max_value);
    }
}
