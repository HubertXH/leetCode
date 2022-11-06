package queuesandstack;

/**
 * No:264. Ugly Number II
 * Medium
 * <p>
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * <p>
 * Given an integer n, return the nth ugly number.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1690
 *
 * @author Hubert
 */
public class UglyNumberII {

    /**
     * DP
     */
    public int nthUglyNumber(int n) {
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return 1;
        }
        int[] resultArrays = new int[n];
        resultArrays[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int index = 1; index < n; index++) {
            resultArrays[index] = Math.min(resultArrays[t2] * 2, Math.min(resultArrays[t3] * 3, resultArrays[t5] * 5));
            if (resultArrays[index] == resultArrays[t2] * 2) {
                t2++;
            }
            if (resultArrays[index] == resultArrays[t3] * 3) {
                t3++;
            }
            if (resultArrays[index] == resultArrays[t5] * 5) {
                t5++;
            }
        }
        return resultArrays[n - 1];
    }
}
