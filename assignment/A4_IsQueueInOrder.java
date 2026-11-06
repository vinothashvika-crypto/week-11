import java.util.Arrays;

/**
 * Week 11 Assignment 4 - Is the Queue in Order? (one pass; equal neighbours are allowed)
 */
public class A4_IsQueueInOrder {

    static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) return i;
        }
        return -1; // empty, single, or fully ordered queue
    }

    static void run(int[] tokens) {
        int index = firstBreak(tokens);
        String note = index == -1 ? "" : " (" + tokens[index] + " comes after " + tokens[index - 1] + ")";
        System.out.println("tokens = " + Arrays.toString(tokens) + " -> " + index + note);
    }

    public static void main(String[] args) {
        run(new int[]{3, 5, 5, 8, 6, 9});
        run(new int[]{1, 2, 2, 7});
        System.out.println("My own tests:");
        run(new int[]{});
        run(new int[]{42});
        run(new int[]{2, 1});
    }
}
