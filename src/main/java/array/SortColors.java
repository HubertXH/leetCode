package array;

/**
 * No:75. Sort Colors
 * Medium
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * <p>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * <p>
 * <p>
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class SortColors {


    public static void sortColors(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }
        sortColorsHelper(nums, 0, nums.length - 1);
    }

    private static void sortColorsHelper(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[left];
        int start = left + 1;
        int end = right;
        while (start < end) {
            while (nums[start] < pivot && start < end) {
                start++;
            }
            while (nums[end] > pivot && start < end) {
                end--;
            }
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
        }
        int temp = nums[start];
        nums[start] = pivot;
        nums[left] = temp;
        sortColorsHelper(nums, left, start - 1);
        sortColorsHelper(nums, start + 1, right);
    }

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
