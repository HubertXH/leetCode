package array;

/**
 * No:162. Find Peak Element
 * Medium
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
 * return the index to any of the peaks.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater
 * than a neighbor that is outside the array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums[i] != nums[i + 1] for all valid i.
 *
 * @author Hubert
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {

        if (nums.length <= 1) {
            return 0;
        }
        return findBuBinarySearch(nums, 0, nums.length - 1);
    }


    /**
     * 寻找局部最大值。
     */
    private static int findBuBinarySearch(int[] nums, int start, int end) {
        int mid = (end - start) / 2 + start;
        if (start == end) {
            return mid;
        }
        if (nums[mid] > nums[mid + 1]) {
            return findBuBinarySearch(nums, start, mid);
        } else {
            return findBuBinarySearch(nums, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 10, 13,11};
        System.out.println(findPeakElement(nums));
    }
}
