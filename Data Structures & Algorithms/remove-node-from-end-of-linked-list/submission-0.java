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

        // Skip n nodes from begin
        int count = n;
        ListNode cur = head;
        while (count-- > 0) {
            if (cur == null) return null;
            cur = cur.next;
        }

        ListNode prev = null;
        ListNode delNode = head;
        while (cur != null) {
            prev = delNode;
            delNode = delNode.next;
            cur = cur.next;
        }
        
        // if first node to be deleted
        if (prev == null) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        prev.next = delNode.next;
        delNode.next = null;
        return head;
    }
}
