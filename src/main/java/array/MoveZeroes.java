package array;

import com.google.gson.Gson;

/**
 * No:283 Easy
 * <p>
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * <p>
 * <p>
 * Follow up: Could you minimize the total number of operations done?
 *
 * @author Hubert
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int count = 0;
        if (nums.length == 1) {
            return;
        }
        int i = 0, j = 0;
        while (j < nums.length && i < nums.length) {
            if (0 == nums[j]) {
                count++;
            }
            if (count <= 0) {
                i++;
                j++;
                continue;
            }
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        if (count <= 0) {
            return;
        }
        for (int index = 1; index <= count; index++) {
            nums[nums.length - index] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,18,19,5,-19,0,-7,-16,0,18,5,11,-17,-18,-17,-20,5,-18,10,-3};
        Gson gson = new Gson();
        moveZeroes(nums);
        System.out.println(gson.toJson(nums));
    }
}