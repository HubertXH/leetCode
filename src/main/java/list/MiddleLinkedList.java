package list;

import entity.ListNode;

/**
 * No:876. Middle of the Linked List  Easy
 * <p>
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * <p>
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * <p>
 * Constraints:
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 *
 * @author Hubert
 */
public class MiddleLinkedList {

    /**
     * 快慢指针
     */
    public static ListNode middleNode(ListNode head) {
        ListNode firstNode = head;
        ListNode behindNode = head;
        int firstSteps = 0;

        while (null != firstNode.next) {
            firstSteps++;
            firstNode = firstNode.next;
            if ((firstSteps % 2) == 0) {
                behindNode = behindNode.next;
            }
        }
        return behindNode.next;
    }

    public static void main(String[] args) {

    }
}
