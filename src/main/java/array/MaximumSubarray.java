package array;

/**
 * No:53 medium
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @author Hubert
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4, 5, 6, 3, 7, -1, -10, -22, 30, -12, 45, 34, -50};
        System.out.println(maxSubArray(nums));
    }
    /**
     * 求一个数组中 和最大的子数组 
     * 用一个临时数temp记录一段数组的和
     * 用一个maximum记录子数组的最大值
     * 遍历数据，temp记录当前子数组的和，每向后遍历一个元素 temp的值就会加上当前元素的值，比较temp与maximum的值将较大的值赋值给maximum。
     * 如果在遍历的过程中，当前元素加上temp后的值小于当前元素的值，
     * 则可以认为前一个子数组可以抛弃掉（子数组的和不会比当前元素重新开始计算数组的和大），
     * 从当前元素开始重新找子数组（即重新标记最大子数组的开始下标位）。即temp可以赋值为当前元素的值。
     * 
     * 最终只需要返回 maximum的值即可。
     */
    public static int maxSubArray(int[] nums) {

        if (null == nums || nums.length <= 0) {
            return 0;
        }
        int maxSum = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = temp + nums[i] > nums[i] ? temp + nums[i] : nums[i];
            maxSum = Math.max(temp, maxSum);
        }
        return maxSum;
    }
}
