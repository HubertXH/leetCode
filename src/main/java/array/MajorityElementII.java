package array;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * No:299 Medium
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 * <p>
 * Input: nums = [1,2]
 * Output: [1,2]
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * Follow up: Could you solve the problem in linear time and in O(1) space?
 * <p>
 * Related Topics
 * Array
 * Hash Table
 * Sorting
 * Counting
 *
 * @author Hubert
 */
public class MajorityElementII {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 3, 3, 3, 6, 3, 56, 3, 3, 6, 3, 3, 3, 6, 3, 9, 6, 3, 3, 3, 2, 2, 5, 622, 2, 2, 2, 2};
        System.out.println(JSON.toJSONString(majorityElement(nums)));
    }

    public static List<Integer> majorityElement(int[] nums) {

        if (null == nums || nums.length <= 0) {
            return null;
        }
        int majority = nums[0];
        int majority2 = nums[0];
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (count1 == 0) {
                majority = num;
                count1++;
                continue;
            }
            if (majority == num) {
                count1++;
                continue;
            }
            if (count2 == 0) {
                majority2 = num;
                count2++;
                continue;
            }
            if (majority2 == num) {
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        return Arrays.asList(majority, majority2);
    }
}
