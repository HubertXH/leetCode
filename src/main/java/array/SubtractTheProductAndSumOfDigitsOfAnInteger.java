package array;

/**
 * No.1281
 * <p>
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * <p>
 * Example 1:
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 * <p>
 * Constraints:
 * 1 <= n <= 10^5
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {

    public static int subtractProductAndSum(int n) {

        if (n < 1 || n > Math.pow(10, 5)) {
            return 0;
        }

        int product = 1;
        int sum = 0;
        while (true) {
            int tempDigits = n % 10;
            sum += tempDigits;
            product *= tempDigits;
            n = n / 10;
            if (n < 1) {
                break;
            }
        }

        return product - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(12365));
    }

}
