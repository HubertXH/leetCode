package array;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(solution(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9})));
    }

    public static int[] solution(int[] digits) {
        if (null == digits) {
            return digits;
        }
        int[] result = new int[digits.length + 1];
        boolean flag = false;
        for (int i = digits.length - 1, j = result.length - 1; i >= 0; i--, j--) {
            int num = digits[i];
            if (i == digits.length - 1 || flag) {
                num++;
                flag = false;
            }
            if (num >= 10) {
                flag = true;
                result[j] = 0;
                if (i == 0) {
                    result[j - 1] = 1;
                }
            } else {
                result[j] = num;
            }
        }
        return result[0] > 0 ? result : Arrays.copyOfRange(result, 1, result.length);
    }
}
