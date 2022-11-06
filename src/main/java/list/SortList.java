package list;

import entity.ListNode;

/**
 * No:148 Medium
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 * Input: head = []
 * Output: []
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 * <p>
 * Related Topics
 * Linked List
 * Two Pointers
 * Divide and Conquer
 * Sorting
 * Merge Sort
 *
 * @author Hubert
 */
public class SortList {

    /**
     * MergeSort
     */
    public ListNode solution(ListNode head) {

        ListNode currentNode = head;
        ListNode tempNode = null;
        ListNode nextNode = currentNode.next;
        while (null != nextNode.next) {
            if (currentNode.val > nextNode.val) {
                tempNode = nextNode.next;
                nextNode.next = currentNode;
                currentNode.next = tempNode;
            }
        }
        return null;
    }
}
