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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        ListNode start = head;
        while (start != null) {
            ListNode end = start;
            ListNode prev = start;
            int count = k;
            while (end != null && count > 0) {
                prev = end;
                end = end.next;
                count--;
            }
            if (count == 0) {
                ListNode nextNode = prev.next;
                prev.next = null;
                ListNode revList = reverse(start);
                tail.next = revList;
                tail = start;
                start = nextNode;
            } else {
                tail.next = start;
                tail = prev;
                start = end;
            }
        }
        ListNode newHead = dummy.next;
        dummy.next = null;
        return newHead;
    }

    private ListNode reverse(ListNode cur) {
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
