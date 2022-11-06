package queuesandstack;

import entity.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * NO:23. Merge k Sorted Lists
 * Hard
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * <p>
 * Input: lists = []
 * Output: []
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 *
 * @author Hubert
 */
public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o2.val, o2.val);
            }
        });

        for (ListNode node : lists) {
            priorityQueue.add(node);
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        while (!priorityQueue.isEmpty()) {
            tail.next = priorityQueue.poll();

            tail = tail.next;
            if (null != tail.next) {
                priorityQueue.add(tail.next);
            }
        }
        return head.next;
    }
}
