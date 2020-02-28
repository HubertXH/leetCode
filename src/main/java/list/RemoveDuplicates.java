package list;

import Entity.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode pre = head;
        ListNode current = head.next;
        ListNode after = current.next;

        while (null != current) {
            if (pre.val == current.val) {
                current = after;
                after = after.next;
                pre.next = current;
                current.next = after;
            } else {
                pre = current;
                current = after;
                after = after.next;
            }
        }
        return head;
    }
}
