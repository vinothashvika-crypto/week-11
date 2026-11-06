import java.util.Arrays;

/**
 * Week 11 Assignment 1 - The Height Line-Up (bubble sort with an early-exit flag; no Arrays.sort)
 */
public class A1_HeightLineUp {

    static void lineUp(int[] heights) {
        int n = heights.length;
        int maxPasses = Math.max(1, n - 1);
        for (int pass = 1; pass <= maxPasses; pass++) {
            boolean swapped = false;
            for (int j = 0; j < n - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            if (!swapped) break; // already in order
        }
    }

    public static void main(String[] args) {
        lineUp(new int[]{4, 2, 5, 1});
        System.out.println();
        lineUp(new int[]{1, 3, 2, 4});
        System.out.println();
        System.out.println("My own test:");
        lineUp(new int[]{9, 7, 8, 7, 1});
    }
}
