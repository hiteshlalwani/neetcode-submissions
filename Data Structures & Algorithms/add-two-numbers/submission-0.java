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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            sum = val1 + val2 + carry;
            ListNode newNode = new ListNode(sum%10);
            tail.next = newNode;
            tail = tail.next;
            carry = sum/10;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        ListNode newHead = dummy.next;
        dummy.next = null;
        return newHead;
    }

    private ListNode reverse(ListNode l1) {
        ListNode prev = null;
        while (l1 != null) {
            ListNode nextNode = l1.next;
            l1.next = prev;
            prev = l1;
            l1 = nextNode;
        }
        return prev;
    }
}
