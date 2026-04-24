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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null && cur.next != null) {
            if (prev == cur) return true;
            cur = cur.next.next;
            prev = prev.next;
        }
        return false;
    }
}
