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
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode curr = head;

        while (curr != null) {
            ListNode groupStart = curr;
            ListNode groupEnd = getKth(curr, k);

            if (groupEnd == null) {
                tail.next = groupStart; // Attach remaining nodes as-is
                break;
            }

            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null; // Disconnect the group to reverse it

            tail.next = reverse(groupStart);
            tail = groupStart; // After reversal, the old start is now the new tail
            curr = nextGroupStart;
        }
        ListNode newHead = dummy.next;
        dummy.next = null;
        return newHead;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 1) {
            curr = curr.next;
            k--;
        }
        return curr;
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
