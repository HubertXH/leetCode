package list;

import Entity.ListNode;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 * <p>
 * Input: head = [0]
 * Output: 0
 * Example 3:
 * <p>
 * Input: head = [1]
 * Output: 1
 * Example 4:
 * <p>
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 * <p>
 * Input: head = [0,0]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */
public class ConvertBinaryNumberInLinkedListToInteger {

    public int getDecimalValue(ListNode head) {

        int result = 0;
        StringBuilder stringBuilder = new StringBuilder();
        ListNode currentNode = head;
        while (null != currentNode) {
            stringBuilder.append(currentNode.val);
            currentNode = currentNode.next;
        }
        result = Integer.valueOf(stringBuilder.toString(), 2).intValue();
        return result;
    }
}
