package array;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * No:27
 * Easy
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 * // It is sorted with no values equaling val.
 * <p>
 * int k = removeElement(nums, val); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * <p>
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 *
 * @author Hubert
 */
public class RemoveElement {


    /**
     * 双指针
     * 同时用result做标志位判断是否碰到第一个val,
     */
    public static int removeElementDoubleIndex(int[] nums, int val) {
        if (null == nums || nums.length <= 0) {
            return 0;
        }
        int result = 0;
        int left = 0, right = 0;
        for (; right < nums.length; right++) {
            if (val == nums[right]) {
                result++;
            }
            if (result <= 0) {
                left++;
                continue;
            }
            if (val != nums[right]) {
                nums[left] = nums[right];
                nums[right] = -1;
                left++;
            }
        }
        return result;
    }

    public static int removeElement(int[] nums, int val) {
        if (null == nums || nums.length <= 0) {
            return 0;
        }

        int beginIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(JSON.toJSONString(nums) + "i====" + i);
            if (nums[i] == val && beginIndex == -1) {
                beginIndex = i;
            }
            if (nums[i] != val && beginIndex != -1) {
                nums[beginIndex] = nums[i];
                if (i < nums.length) {
                    beginIndex++;
                }
            }
        }
        beginIndex = beginIndex == -1 ? nums.length : beginIndex;
        nums = Arrays.copyOf(nums, Math.min(beginIndex, nums.length));
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{2, 2, 2, 3, 4, 2, 0, 10, 8, 9, 7, 9, 6, 5, 1, 1};
//        System.out.println(removeElement(new int[]{2}, 3));
        System.out.println(removeElementDoubleIndex(arrays, 2));
        System.out.println(JSON.toJSONString(arrays));
    }
}
