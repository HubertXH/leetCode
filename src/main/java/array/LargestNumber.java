package array;

/**
 * No:179. Largest Number
 * Medium
 * <p>
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * <p>
 * Since the result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 10^9
 *
 * @author Hubert
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        sortArrays(nums, 0, nums.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    private void sortArrays(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pIndex = startIndex;
        int left = startIndex;
        int right = endIndex;

        while (left < right) {
            while (left < right && compareNum(nums[left], nums[pIndex]) < 0) {
                left++;
            }

            while (left < right && compareNum(nums[right], nums[pIndex]) > 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        int temp = nums[left];
        nums[left] = nums[pIndex];
        nums[pIndex] = temp;
        pIndex = left;
        sortArrays(nums, startIndex, pIndex);
        sortArrays(nums, pIndex, endIndex);
    }

    private int compareNum(int num, int target) {
        return Integer.compare(String.valueOf(num).charAt(0), String.valueOf(target).charAt(0));
    }


    private void quickSort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pIndex = startIndex;
        int left = startIndex;
        int right = endIndex;

        while (left < right) {
            while (left < right && nums[left] < nums[pIndex]) {
                left++;
            }

            while (left < right && nums[right] > nums[pIndex]) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        int temp = nums[left];
        nums[left] = nums[pIndex];
        nums[pIndex] = temp;
        pIndex = left;
        sortArrays(nums, startIndex, pIndex);
        sortArrays(nums, pIndex, endIndex);
    }
}
