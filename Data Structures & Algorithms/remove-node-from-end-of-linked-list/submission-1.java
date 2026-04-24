/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. Initialize a dummy node pointing to the head
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        // 2. Advance 'right' pointer so there is a gap of n between left and right
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }

        // 3. Move both pointers until 'right' reaches the end
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // 4. Delete the node (left.next is the node to be removed)
        left.next = left.next.next;
        ListNode newHead = dummy.next;
        dummy.next = null;
        return newHead;
    }
}