package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No:1 Easy
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 * <p>
 * <p>
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 *
 * @author Hubert
 */
public class TwoSum {

    public Integer[] twoSum(int[] nums, int target) {
        List<Integer> resultList = new ArrayList<>();
        Arrays.sort(nums);
        int firstIndex = 0, lastIndex = nums.length - 1;
        while (firstIndex < lastIndex) {
            if (target - nums[firstIndex] > nums[lastIndex]) {
                firstIndex++;
            } else if (target - nums[firstIndex] < nums[lastIndex]) {
                lastIndex--;
            } else if (target - nums[firstIndex] == nums[lastIndex]) {
                resultList.add(firstIndex);
                resultList.add(lastIndex);
                break;
            }
        }
        return resultList.toArray(new Integer[0]);
    }
}
