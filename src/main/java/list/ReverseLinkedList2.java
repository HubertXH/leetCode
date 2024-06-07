package list;

import com.alibaba.fastjson.JSON;
import entity.ListNode;

/**
 * No.92 Reverse Linked List II
 * Medium
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * INPUT:  1 -> 2 -> 3 -> 4 -> 5
 * OUTPUT: 1 -> 4 -> 3 -> 2 -> 5
 * <p>
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 * <p>
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * Follow up: Could you do it in one pass?
 *
 * @author hubert
 */
public class ReverseLinkedList2 {

    /**
     * 需要一个node(beforeNode)来记录left的前一位置对应的节点，一个node(lastNode)记录left位置对应的节点
     *
     * @param head  链表头
     * @param left  反转开始节点
     * @param right 反转结束节点
     * @return 反转后的连表开始节点
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (null == head || null == head.next) {
            return head;
        }
        int count = 2;
        ListNode beforeNode = head;
        ListNode lastNode = head.next;

        ListNode currentNode = head.next;
        ListNode preNode = head;
        ListNode afterNode = currentNode.next;
        while (true) {
            if (count < left) {
                preNode = currentNode;
                currentNode = afterNode;
                afterNode = afterNode.next;
                count++;
                continue;
            }
            if (count == left) {
                beforeNode = preNode;
                lastNode = currentNode;

            }
            if (count >= right) {
                currentNode.next = preNode;
                break;
            }
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = afterNode;
            afterNode = afterNode.next;
            if (null == afterNode) {
                break;
            }
            count++;

        }
        beforeNode.next = currentNode;
        lastNode.next = afterNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNodeFromArray(new int[]{1,2,3,4,5});
        ListNode resultNode = reverseBetween(head,2,4);
        System.out.println(JSON.toJSONString(ListNode.convertToArrays(resultNode)));
    }
}
