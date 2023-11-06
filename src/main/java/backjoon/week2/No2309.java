package backjoon.week2;

import java.util.Arrays;
import java.util.Scanner;

public class No2309 {

    static final int REAL_NANGEN_COUNT = 7;
    static final int FALSE_NANGEN_COUNT = 9;
    static int nangen[] = new int[FALSE_NANGEN_COUNT];
    static int[] temporaryNangen = new int[REAL_NANGEN_COUNT];
    static int[] answers;

    static void DFS(int idx, int swapIdx) {
        if (swapIdx == REAL_NANGEN_COUNT) {
            int sum = 0;
            for (int i = 0; i < REAL_NANGEN_COUNT; i++)
                sum += temporaryNangen[i];
            if (sum == 100) {
                answers = temporaryNangen.clone();
            }
            return;
        }
        if (idx == FALSE_NANGEN_COUNT) {
            return;
        }

        temporaryNangen[swapIdx] = nangen[idx];
        DFS(idx+1, swapIdx+1);
        DFS(idx+1, swapIdx);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < FALSE_NANGEN_COUNT; i++) {
            nangen[i] = scanner.nextInt();
        }
        DFS(0,0);
        Arrays.sort(answers);
        for (int i : answers) {
            System.out.println(i);
        }
    }
}
