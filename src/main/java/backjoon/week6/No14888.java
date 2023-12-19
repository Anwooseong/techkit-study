package backjoon.week6;

import java.util.Scanner;

public class No14888 {
    static int N;
    static int[] numList;
    static int add, minus, multi, div;
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        numList = new int[N];
        for (int i = 0; i < N; i++) {
            numList[i] = scanner.nextInt();
        }

        add = scanner.nextInt();
        minus = scanner.nextInt();
        multi = scanner.nextInt();
        div = scanner.nextInt();

        dfs(numList[0], add, minus, multi, div, 1);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    static void dfs(int numValue, int add, int minus, int multi, int div, int index) {
        if (add > 0) {
            dfs(numValue + numList[index], add - 1, minus, multi, div, index + 1);
        }
        if (minus > 0) {
            dfs(numValue - numList[index], add, minus - 1, multi, div, index + 1);
        }
        if (multi > 0) {
            dfs(numValue * numList[index], add, minus, multi - 1, div, index + 1);
        }
        if (div > 0) {
            if (numValue < 0) {
                dfs(-(-numValue / numList[index]), add, minus, multi, div - 1, index + 1);
            } else {
                dfs(numValue / numList[index], add, minus, multi, div - 1, index + 1);
            }
        }

        if (index == N) {
            if (maxValue <= numValue) {
                maxValue = numValue;
            }
            if (minValue >= numValue) {
                minValue = numValue;
            }
        }
    }
}