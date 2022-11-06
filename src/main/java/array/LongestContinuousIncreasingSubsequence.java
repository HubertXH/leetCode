package array;

/**
 * No:674  Easy
 * Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray).
 * The subsequence must be strictly increasing.
 * <p>
 * A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is
 * [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
 * Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
 * 4.
 * Example 2:
 * <p>
 * Input: nums = [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
 * increasing.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 *
 * @author Hubert
 */
public class LongestContinuousIncreasingSubsequence {

    /**
     * 双指针
     */
    public static int findLengthOfLCIS(int[] nums) {
        if (null == nums) {
            return 0;
        }

        int resultIndex = 0;
        int maxLength = 1;
        int tempIndex = 0;
        int tempLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                tempLength++;
            } else {
                if (tempLength > maxLength) {
                    maxLength = tempLength;
                    resultIndex = tempIndex;
                }
                tempIndex = i;
                tempLength = 1;
            }
        }
        System.out.println(resultIndex + ":" + maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{28, 0, 28, 24, 6, 18, 21, 25, 23, 13, 7, 19, 23, 5, 6, 6, 7, 26, 6, 21};
        System.out.println(findLengthOfLCIS(arrays));
    }
}
