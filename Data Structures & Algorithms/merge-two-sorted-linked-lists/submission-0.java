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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;
        while (list1 != null || list2 != null) {
            ListNode cur = list1;
            ListNode nextNode;
            if (list2 == null) {
                cur = list1;
                nextNode = list1.next;
                list1.next = null;
                list1 = nextNode;
            } else if (list1 == null) {
                cur = list2;
                nextNode = list2.next;
                list2.next = null;
                list2 = nextNode;
            } else if (list1.val <= list2.val) {
                cur = list1;
                nextNode = list1.next;
                list1.next = null;
                list1 = nextNode;
            } else {
                cur = list2;
                nextNode = list2.next;
                list2.next = null;
                list2 = nextNode;
            }
            if (tail == null) {
                head = tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
        }
        return head;
    }
}