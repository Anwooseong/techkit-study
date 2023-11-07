import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int NANGEN_COUNT = 7;
    static int FALSE_NANGEN_COUNT = 9;
    static int nangen[] = new int[FALSE_NANGEN_COUNT];
    static int sel[] = new int[NANGEN_COUNT];
    static int h_idx[];

    static void Search(int idx, int swapIndex) {
        if (swapIndex == NANGEN_COUNT) {
            int sum = 0;
            for (int i = 0; i < NANGEN_COUNT; i++)
                sum += sel[i];
            if (sum == 100) {
                h_idx = (int[])sel.clone();
            }

            return;
        }
        if(idx == FALSE_NANGEN_COUNT)
            return;

        sel[swapIndex] = nangen[idx];
        Search(idx+1, swapIndex+1);
        Search(idx+1, swapIndex);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < FALSE_NANGEN_COUNT; i++)
            nangen[i] = sc.nextInt();


        Search(0,0);
        Arrays.sort(h_idx);
        for(int i : h_idx)
            System.out.println(i);


    }
}