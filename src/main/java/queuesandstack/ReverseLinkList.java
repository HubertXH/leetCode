package queuesandstack;

import entity.ListNode;

/**
 * No:206 Easy
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 * Input: head = []
 * Output: []
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * <p>
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author Hubert
 */
public class ReverseLinkList {

    public ListNode iterativelyReverse(ListNode head) {
        if (null == head) {
            return null;
        }
        if (null == head.next) {
            return head;
        }
        ListNode currentNode = head.next;
        ListNode preNode = head;
        ListNode afterNode = currentNode.next;
        while (true) {
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = afterNode;
            if (null == afterNode.next) {
                break;
            }
            afterNode = afterNode.next;
        }
        return currentNode;
    }

    public ListNode recursivelyReverse(ListNode head) {
        if (null == head) {
            return null;
        }
        return reverseList(null, head.next);
    }

    private ListNode reverseList(ListNode perNode, ListNode currentNode) {
        ListNode nextNode = currentNode.next;
        currentNode.next = perNode;
        if (null == nextNode) {
            return currentNode;
        }
        return reverseList(currentNode, nextNode);
    }


}
