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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = findMiddleNode(head);
        ListNode list1 = head;
        ListNode list2 = mid.next;
        mid.next = null;
        list2 = reverse(list2);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            ListNode nextNode = list1.next;
            list1.next = null;
            tail.next = list1;
            list1 = nextNode;
            tail = tail.next;

            nextNode = list2.next;
            list2.next = null;
            tail.next = list2;
            list2 = nextNode;
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        }
        // ListNode newHead = dummy.next;
        // dummy.next = null;
        // return newHead;
    }

    // find middle
    private ListNode findMiddleNode(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null && cur.next != null) {
            cur = cur.next.next;
            prev = prev.next;
        }
        return prev;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }
}
