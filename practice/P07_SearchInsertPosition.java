import java.util.Arrays;

/**
 * Week 11 Practice 7 - Insert Position in a Sorted List (binary search)
 *
 * Complexity: O(log n) time, O(1) space - suitable for very large arrays queried often.
 */
public class P07_SearchInsertPosition {

    static int searchInsertPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low; // where the target would be inserted
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println("nums = " + Arrays.toString(nums) + ", target = 5 -> " + searchInsertPosition(nums, 5));
        System.out.println("nums = " + Arrays.toString(nums) + ", target = 2 -> " + searchInsertPosition(nums, 2));
    }
}
