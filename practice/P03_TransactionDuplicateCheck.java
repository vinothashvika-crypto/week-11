import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Week 11 Practice 3 - Transaction Duplicate Check
 *
 * Chosen (fastest): HashSet - O(n) average time, O(n) extra space.
 * Alternative (less memory, slower): sort a copy then compare neighbours - O(n log n) time,
 * O(1) extra space if sorting in place (or nested loops: O(n^2) time, O(1) space).
 * Trade-off: the hash set spends memory on every ID to get constant-time lookups; with millions
 * of IDs nightly and a time-sensitive check, that memory is worth the speed.
 */
public class P03_TransactionDuplicateCheck {

    static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<String>();
        for (String id : transactionIds) {
            if (!seen.add(id)) return true; // add() returns false if it was already there
        }
        return false;
    }

    // The lower-memory alternative, for comparison
    static boolean hasDuplicateBySorting(String[] transactionIds) {
        String[] copy = transactionIds.clone();
        Arrays.sort(copy);
        for (int i = 1; i < copy.length; i++) {
            if (copy[i].equals(copy[i - 1])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] batches = {
                {"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"},
                {"TXN2001", "TXN2002", "TXN2003"}
        };
        for (String[] batch : batches) {
            System.out.println(hasDuplicate(batch) + "   (sorting approach agrees: " + (hasDuplicateBySorting(batch) == hasDuplicate(batch)) + ")");
        }
    }
}
