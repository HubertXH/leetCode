package array;

import java.util.Arrays;

/**
 * No.1313
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 * Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).
 * For each such pair, there are a elements with value b in the decompressed list.
 * Return the decompressed list.
 */
public class DecompressRunLengthEncodedList {

    public int[] decompressRLEList(int[] nums) {
        if (null == nums) {
            return null;
        }
        if (nums.length % 2 != 0) {
            return nums;
        }
        int[] result = new int[5000];
        int arraysIndex = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int step = 0; step < nums[i]; step++) {
                if (arraysIndex >= result.length) {
                    result = Arrays.copyOf(result, result.length * 2);
                }
                result[arraysIndex] = nums[i + 1];
                arraysIndex++;
            }
        }
        return Arrays.copyOf(result, arraysIndex + 1);
    }

}
