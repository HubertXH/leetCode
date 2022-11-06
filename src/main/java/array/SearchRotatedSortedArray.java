package array;

/**
 * No:33. Search in Rotated Sorted Array
 * Medium
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * <p>
 * Input: nums = [1], target = 0
 * Output: -1
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * numsis an ascending array that is possibly rotated.
 * -10^4 <= target <= 10^4
 *
 * @author Hubert
 */
public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums[0] < nums[nums.length - 1]) {
            return binarySearch(nums, target);
        }

        // find the smallest value index in nums
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            // the smallest value at the right part of arrays
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // at last low equals high so the smallest value index is low
        // and the largest value's index is low-1;
        if (nums[0] <= target && nums[low - 1] >= target) {
            return binarySearch(nums, target, 0, low - 1);
        } else {
            return binarySearch(nums, target, low, nums.length - 1);
        }
    }

    public static int binarySearch(int[] nums, int target, int low, int high) {

        int mid = (low + high) / 2;
        while (low < high) {
            if (target > nums[mid]) {
                low = mid;
                mid = (low + high) / 2;
            } else if (target < nums[mid]) {
                high = mid;
                mid = (low + high) / 2;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target) {

        int low = 0, high = nums.length - 1, mid = (low + high) / 2;
        while (low < high) {
            if (target > nums[mid]) {
                low = mid;
                mid = (low + high) / 2;
            } else if (target < nums[mid]) {
                high = mid;
                mid = (low + high) / 2;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(29 / 5);
    }
}
