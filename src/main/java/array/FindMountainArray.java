package array;

import entity.MountainArray;

/**
 * No:1095. Find in Mountain Array
 * Hard
 * (This problem is an interactive problem.)
 * <p>
 * You may recall that an array arr is a mountain array if and only if:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
 * <p>
 * You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
 * <p>
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 * Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: array = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 * Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 * Example 2:
 * <p>
 * Input: array = [0,1,2,4,2,1], target = 3
 * Output: -1
 * Explanation: 3 does not exist in the array, so we return -1.
 * <p>
 * Constraints:
 * <p>
 * 3 <= mountain_arr.length() <= 10^4
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 *
 * @author Hubert
 */
public class FindMountainArray {

    /**
     * 使用二分法，
     * 先去中间值，判断与目标值的大小，
     * 判断中间值左边的升降序列
     */
    public static int findInMountainArray(int target, MountainArray mountainArr) {

        int mid = 0;
        int left = 0;
        int right = mountainArr.length() - 1;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (mountainArr.get(mid) > target) {
                right = mid;
                continue;
            }
            if (mountainArr.get(mid) < target) {
                // 升序
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    left = mid;
                    continue;
                }
                // 降序
                if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                    right = mid;
                }
            }
        }
        return mountainArr.get(mid) == target ? mid : -1;
    }
}
