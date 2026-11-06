import java.util.Arrays;

/**
 * Week 11 Assignment 2 - The Prize Table (selection sort, descending; counts real swaps only)
 */
public class A2_PrizeTable {

    static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIndex]) maxIndex = j;
            }
            if (maxIndex != i) {             // don't count a round that needs no swap
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    static void run(int[] marks) {
        int swaps = prizeTable(marks);
        System.out.println(Arrays.toString(marks) + " swaps = " + swaps);
    }

    public static void main(String[] args) {
        run(new int[]{45, 90, 60, 75});
        run(new int[]{80, 70, 60});
        System.out.print("My own test: ");
        run(new int[]{10, 20, 30, 40, 50});
    }
}
