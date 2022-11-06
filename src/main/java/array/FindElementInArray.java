package array;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Find First and Last Position of Element in Sorted Array
 * No:34 Medium
 * <p>
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 *
 * @author Hubert
 */
public class FindElementInArray {

    /**
     * binary search
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length <= 0) {
            return new int[]{-1, -1};
        }
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }

        int startIndex = (nums.length - 1) / 2;
        int endIndex = nums.length - 1;
        while (true) {
            if (startIndex >= endIndex) {
                return new int[]{-1, -1};
            }
            if (nums[startIndex] < target) {
                int dis = (endIndex - startIndex) / 2 == 0 ? 1 : (endIndex - startIndex) / 2;
                startIndex = startIndex + dis;

            } else if (nums[startIndex] > target) {
                endIndex = startIndex;
                startIndex = startIndex / 2;
            } else {
                endIndex = startIndex + 1;
                startIndex = startIndex - 1;
                while (startIndex >= 0 && endIndex < nums.length && (nums[startIndex] == target || nums[endIndex] == target)) {
                    if (nums[startIndex] == target) {
                        startIndex--;
                    }
                    if (nums[endIndex] == target) {
                        endIndex++;
                    }
                }
                break;
            }
        }
        return new int[]{startIndex + 1, endIndex - 1};
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 8, 9, 10, 10, 10, 10};
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(searchRange(arrays, 1)));
    }
}
