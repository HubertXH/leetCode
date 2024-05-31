package queuesandstack;

import java.util.Stack;

/**
 * No:150. Evaluate Reverse Polish Notation
 * Medium
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * <p>
 * Note that division between two integers should truncate toward zero.
 * <p>
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 *
 * @author Hubert
 */
public class EvaluateReversePolishNotation {

    /**
     * RPN-逆波兰表达式
     * 特点：不使用括号就可以表达计算的先后顺序。
     * 使用栈来进行数学表达式计算。
     * 在读取表达式的过程中，遇到数字则将数字入栈，如果遇到的是计算符号则将栈顶的元素进行计算，并将结果重新入栈。
     * 最后返回栈顶的元素即得到最终的值
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if ("+".equals(str)) {
                stack.add(stack.pop() + stack.pop());
            } else if ("-".equals(str)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b - a);
            } else if ("*".equals(str)) {
                stack.add(stack.pop() * stack.pop());
            } else if ("/".equals(str)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b / a);
            } else {
                stack.add(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
