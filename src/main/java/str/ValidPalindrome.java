package str;

/**
 * No:125
 * Easy
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * <p>
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2 * 10^5
 * s consists only of printable ASCII characters.
 *
 * @author Hubert
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        String tempStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int low = 0, high = s.length() - 1;
        boolean result = true;
        while (low < high && result) {
            if (tempStr.indexOf(s.charAt(low)) > 0 && tempStr.indexOf(s.charAt(high)) > 0) {
                result = Character.toLowerCase(s.charAt(low)) == Character.toLowerCase(s.charAt(high));
                low++;
                high--;
            }
            if (tempStr.indexOf(s.charAt(low)) < 0) {
                low++;
                continue;
            }
            if (tempStr.indexOf(s.charAt(high)) < 0) {
                high--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
