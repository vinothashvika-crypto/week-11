import java.util.Arrays;

/**
 * Week 11 Assignment 5 - The Dice Throw Tally (counting sort for values 1..6; no comparisons between throws)
 */
public class A5_DiceThrowTally {

    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];          // count[v] = how many times v was thrown
        for (int roll : rolls) count[roll]++;

        StringBuilder counts = new StringBuilder("Counts:");
        for (int v = 1; v <= 6; v++) counts.append(" ").append(v).append(":").append(count[v]);
        System.out.println(counts);

        int[] sorted = new int[rolls.length];
        int k = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) sorted[k++] = v;
        }
        return sorted;
    }

    public static void main(String[] args) {
        System.out.println("Sorted: " + Arrays.toString(diceSort(new int[]{4, 1, 6, 4, 2, 1, 4})));
        System.out.println();
        System.out.println("My own test:");
        System.out.println("Sorted: " + Arrays.toString(diceSort(new int[]{6, 6, 5, 3, 3, 3, 1, 2})));
    }
}
