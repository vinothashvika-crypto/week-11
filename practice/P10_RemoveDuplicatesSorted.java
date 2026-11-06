import java.util.Arrays;

/**
 * Week 11 Practice 10 - Remove Duplicates From a Sorted Array In-Place
 *
 * Complexity: O(n) time, O(1) additional space - only two index variables are used and the
 * input array itself is overwritten, so no second array is needed (that's what makes it in-place).
 */
public class P10_RemoveDuplicatesSorted {

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int write = 1;                       // next position for a unique value
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write - 1]) {
                nums[write++] = nums[read];
            }
        }
        return write;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        System.out.println("nums[0.." + (length - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, length)));
    }
}
