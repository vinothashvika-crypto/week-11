import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Week 11 Practice 5 - Pair With Target Sum (unsorted input)
 *
 * Approach 1 - brute force: check every pair.      O(n^2) time, O(1) space.
 * Approach 2 - hash set of complements:             O(n) average time, O(n) space.
 * Approach 3 - sort a copy + two pointers:          O(n log n) time, O(n) space for the copy (O(1) if sorting in place).
 */
public class P05_PairWithTargetSum {

    static boolean hasPairBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) return true;
        return false;
    }

    static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int n : nums) {
            if (seen.contains(target - n)) return true; // complement seen at an earlier (distinct) index
            seen.add(n);
        }
        return false;
    }

    static boolean hasPairSortedTwoPointers(int[] nums, int target) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int left = 0, right = sorted.length - 1;
        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == target) return true;
            if (sum < target) left++;
            else right--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] inputs = {{2, 7, 11, 15}, {3, 4, 6}};
        int[] targets = {9, 20};
        for (int t = 0; t < inputs.length; t++) {
            boolean result = hasPairWithSum(inputs[t], targets[t]);
            System.out.println("nums = " + Arrays.toString(inputs[t]) + ", target = " + targets[t] + " -> " + result
                    + "  (brute force: " + hasPairBruteForce(inputs[t], targets[t])
                    + ", two pointers: " + hasPairSortedTwoPointers(inputs[t], targets[t]) + ")");
        }
    }
}
