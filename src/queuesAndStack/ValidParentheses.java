package queuesAndStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    /**
     * 利用栈的特性，如果是左边的就直接压入栈中，若是右半部分则分情况判断：
     * 1、栈为空 返回false
     * 2、栈的第一个元素和当前元素组成一对，则出栈第一个元素进入下一轮
     * 3、如果不能组成一组则直接返回false
     */
    public boolean isValid(String s) {
        if (null == s || s.length() <= 0) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // if the character is left part put it into stack
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
                // if the character is the right part and the stack is empty return false
            } else if (stack.isEmpty()) {
                return false;
                // if the stack is not empty and pop the first element,if is equals to the elements
            } else if (map.get(stack.peek()).equals(s.charAt(i))) {
                stack.pop();
                continue;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
