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

    /**
     * 需要三个额外的节点引用来记录 当前节点，当前节点的前一个节点以及后一个节点。
     * 链表的反转行为：
     * 将当前节点的next值，指向前一个节点，即完成了一次节点的反正(当前节点与前一个节点的反转)。反转完成后需要将这三个节点整体向后移动。
     * 将当前的节点的next值，1、指向前一个节点，2、将前一个节点的引用变更为当前节点，3、当前节点值应用变更为后一个节点，4、后一个节点变成后一个节点的next的指向值
     * @param head 输入的需要反转的链表头
     * @return 反转完成的链接头
     */
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
