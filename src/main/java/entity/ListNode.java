package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hubert
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode buildListNodeFromArray(int[] arrays) {

        ListNode head = new ListNode(arrays[0]);
        ListNode currentNode = head;
        for (int i = 1; i < arrays.length; i++) {
            currentNode.next = new ListNode(arrays[i]);
            currentNode = currentNode.next;
        }
        return head;
    }

    public static Integer[] convertToArrays(ListNode head){
        List<Integer>  result = new ArrayList<>();
        ListNode currentNode = head;
        while (null != currentNode) {
            result.add(currentNode.val);
            currentNode = currentNode.next;
        }
        return result.toArray(new Integer[0]);
    }

}
