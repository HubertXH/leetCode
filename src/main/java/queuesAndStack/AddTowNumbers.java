package queuesAndStack;

/**
 * No.2
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTowNumbers {

    public ListNode Solution(ListNode l1, ListNode l2) {

        if (null == l1 && null == l2) {
            return null;
        }
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        int tempDigits = 0;
        ListNode result = null;
        if (l1.val + l2.val >= 10) {
            tempDigits = (l1.val + l2.val) / 10;
            result = new ListNode((l1.val + l2.val) % 10);
        } else {
            result = new ListNode(l1.val + l2.val);
        }
        ListNode temp = result;
        l1 = l1.next;
        l2 = l2.next;
        while (null != l1 || null != l2 || tempDigits > 0) {
            int value = 0;
            if (tempDigits > 0) {
                value += tempDigits;
                tempDigits = 0;
            }
            if (null != l1) {
                value += l1.val;
            }
            if (null != l2) {
                value += l2.val;
            }
            if (value >= 10) {
                tempDigits = value / 10;
                value = value % 10;
            }
            temp.next = new ListNode(value);
            temp = temp.next;
            l1 = null == l1 ? null : l1.next;
            l2 = null == l2 ? null : l2.next;
        }
        return result;
    }


}
