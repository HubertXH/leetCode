package array;

import java.util.HashMap;
import java.util.Map;

/**
 * No:523. Continuous Subarray Sum
 * Medium
 * <p>
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
 * <p>
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 * Example 2:
 * <p>
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 * Example 3:
 * <p>
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= sum(nums[i]) <= 2^31 - 1
 * 1 <= k <= 2^31 - 1
 *
 * @author Hubert
 */
public class ContinuousSubarraySum {

    /**
     * 前缀匹配法。
     * 前N个值得和对K取模，如果余数第一次出现则存储起来。如果余数第二次出现则从第一次出现的下标为开始到第二次出现的下标位之间，一定存在x*k的值
     */
    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> modelValueMap = new HashMap<>();
        modelValueMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!modelValueMap.containsKey(sum % k)) {
                modelValueMap.put(sum % k, i);
                // to ensure at lest there are two element
            } else if (modelValueMap.get(sum % k) + 1 < i) {
                return true;
            }
        }
        return false;
    }
}
