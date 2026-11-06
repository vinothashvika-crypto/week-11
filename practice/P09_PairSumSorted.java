import java.util.Arrays;

/**
 * Week 11 Practice 9 - Pair Sum in a Sorted Array (two pointers)
 *
 * Two pointers on the sorted array: O(n) time, O(1) space.
 * Ignoring the sorted order (checking every pair): O(n^2) time.
 */
public class P09_PairSumSorted {

    // Returns the pair, or null if no pair exists
    static int[] pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return new int[]{nums[left], nums[right]};
            if (sum < target) left++;   // need a bigger sum
            else right--;               // need a smaller sum
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] inputs = {{-4, -1, 0, 3, 5, 9}, {1, 2, 3}};
        int[] targets = {4, 100};
        for (int t = 0; t < inputs.length; t++) {
            int[] pair = pairSumSorted(inputs[t], targets[t]);
            System.out.println("nums = " + Arrays.toString(inputs[t]) + ", target = " + targets[t] + " -> "
                    + (pair == null ? "Not Found" : "(" + pair[0] + ", " + pair[1] + ")"));
        }
    }
}
