package list;

import entity.ListNode;

/**
 * No:141. Linked List Cycle
 * Easy
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * Example 3:
 * <p>
 * <p>
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 * @author Hubert
 */
public class LinkedListCycle {

    /**
     * 快慢指针转圈，一定会相遇
     */
    public boolean hasCycle(ListNode head) {
        int step = 0;
        ListNode firstNode = head;
        ListNode secondNode = head;
        while (null != head.next) {
            firstNode = firstNode.next;
            step++;
            if ((step & 1) == 0) {
                secondNode = secondNode.next;
            }
            if (secondNode == firstNode) {
                return true;
            }
        }
        return false;
    }
}
