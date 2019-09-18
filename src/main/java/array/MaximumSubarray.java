package array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4, 5, 6, 3, 7, -1, -10, -22, 30, -12, 45, 34, -50};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        if (null == nums || nums.length <= 0) {
            return 0;
        }
        int maxSum = 0;
        int temp = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (temp + nums[i] >= temp) {
                temp = temp + nums[i];
            } else {
                j++;
                temp = nums[j];
                i = j;
            }
            maxSum = maxSum < temp ? temp : maxSum;
            System.out.println(maxSum + "====|=== i =" + i + ",=| j=" + j + ",temp=" + temp);
        }
        return maxSum;
    }
}
