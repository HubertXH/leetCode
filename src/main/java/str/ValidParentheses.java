package str;

import java.util.Stack;

/**
 * No:20. Valid Parentheses
 * Easy
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 *
 * @author Hubert
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (null == s || (s.length() & 1) != 0) {
            return false;
        }
        Stack<String> fullChar = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String temps = String.valueOf(s.charAt(i));
            if (")".equals(temps) && "(".equals(fullChar.peek())) {
                fullChar.pop();
                continue;
            }
            if ("]".equals(temps) && "[".equals(fullChar.peek())) {
                fullChar.pop();
                continue;
            }
            if ("}".equals(temps) && "{".equals(fullChar.peek())) {
                fullChar.pop();
                continue;
            }
            fullChar.add(temps);
        }
        return fullChar.isEmpty();
    }
}
