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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            queue.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            ListNode next = cur.next;
            tail.next = cur;
            cur.next = null;
            tail = tail.next;
            if (next != null) {
                queue.offer(next);
            }
        }

        ListNode head = dummy.next;
        dummy.next = null;
        return head;
    }
}
