/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copyMap = new HashMap<>();

        Node dummy = new Node(0);
        Node tail = dummy;
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            copyMap.put(cur, newNode);
            tail.next = newNode;
            tail = tail.next;
            cur = cur.next;
        }
        cur = head;
        tail = dummy.next;
        while (cur != null) {
            if (cur.random != null) {
                tail.random = copyMap.get(cur.random);
            }
            cur = cur.next;
            tail = tail.next;
        }
        Node newHead = dummy.next;
        dummy.next = null;
        return newHead;
    }
}
