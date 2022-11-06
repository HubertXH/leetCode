package str;

/**
 * No:409 Easy
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome(回文) that can be built with those letters.
 * <p>
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 * <p>
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 *
 * @author Hubert
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String str = "sddddddddddfdsadfaaaaaaadsfsefcccxbhawiemlaienWONDoaiwanlakdnfoainadjsnfqienasef";
        System.out.println(longestPalindrome(str));
    }

    public static int longestPalindrome(String s) {
        // the letter's max char value is 122, so each array index represent a letter, and the value of each index is the count of letter
        int[] letterNums = new int[123];
        if (1 == s.length()) {
            return 1;
        }

        // statistic each letter's number
        for (int index = 0; index < s.length(); index++) {
            letterNums[s.charAt(index)] = letterNums[s.charAt(index)] + 1;
        }
        boolean flag = true;
        int count = 0;
        // loop the array and calculate the result
        for (int num : letterNums) {
            if (0 >= num) {
                continue;
            }
            if (flag && (num & 1) == 1) {
                count++;
                flag = false;
            }
            if ((num & 1) == 0) {
                count += num;
            } else if (num > 1) {
                count += (num - 1);
            }
        }
        return count;
    }
}
