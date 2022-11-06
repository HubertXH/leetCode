package array;

/**
 * No:169 Easy
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * Related Topics
 * Array
 * Hash Table
 * Divide and Conquer
 * Sorting
 * Counting
 *
 * @author Hubert
 */
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{66, 6, 6, 7, 6, 666, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 90, 77, 6, 7, 7, 6, 7}));
    }

    /**
     * Boyer–Moore 投票算法
     * 适用于最多元素出现的次数超过数组一半以上的情况。可理解为出现最多的元素出现的次数与其所有元素出现的次数做抵消，
     * 因为出现最多的元素超过了一半，则最后留下来的一定是出现最多的元素
     *
     * @param nums 数组
     * @return 多数元素
     */
    public static int majorityElement(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return 0;
        }
        int majority = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                majority = num;
                count++;
                continue;
            }
            if (majority == num) {
                count++;
                continue;
            }
            count--;
        }
        return majority;
    }
}
