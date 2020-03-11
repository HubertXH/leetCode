package str;

import org.apache.commons.lang3.StringUtils;

/**
 * 1323
 *
 * Given a positive integer num consisting only of digits 6 and 9.
 * <p>
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 * Example 2:
 * <p>
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 * Example 3:
 * <p>
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 10^4
 * num's digits are 6 or 9
 */
public class Maximum69Number {

    public static int solution(int num) {
        String strNum = String.valueOf(num);
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) == '6') {
                result.append(9);
                if (i + 1 < strNum.length()) {
                    result.append(strNum.substring(i + 1));
                }
                break;
            } else {
                result.append(strNum.charAt(i));
            }
        }
        return Integer.valueOf(result.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution(9669));
    }

}
