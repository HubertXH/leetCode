package array;

/**
 * No.1295
 *
 * <p>
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 */

public class FindNumberWithEvenNumbersDigits {


    public int findNumbers(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return 0;
        }
        int count = 0;
        for (int index = 0; index < nums.length; index++) {
            if (isEvenNumbersDigits(nums[index])) {
                count++;
            }
        }
        return count;
    }

    private boolean isEvenNumbersDigits(int num) {

        if (num / 100000 > 0) {
            return true;
        }

        if (num / 1000 > 0 && num / 1000 < 10) {
            return true;
        }

        if (num / 10 > 0 && num / 10 < 10) {
            return true;
        }
        return false;
    }
}
