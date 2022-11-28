package array;

/**
 * No:1004. Max Consecutive Ones III
 * Medium
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 *
 * @author hengxu
 */
public class MaxConsecutiveOnesIII {


    /**
     * 找到数组中，包含K个0的最长子序列
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        for (; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
        }
        return right - left;
    }
}
