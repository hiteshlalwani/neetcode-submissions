class LRUCache {
    private class Node {
        int key, val;
        Node prev, next;
        Node(int k, int v) { key = k; val = v; }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;
    private Node head = new Node(0, 0); // Dummy Head (MRU side)
    private Node tail = new Node(0, 0); // Dummy Tail (LRU side)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node); // Move to head (MRU)
        return node.val;
    }

    public void put(int key, int value) {
        Node target = map.get(key);
        if (target == null) {
            target = new Node(key, value);
            map.put(key, target);
        } else {
            target.val = value;
            remove(target);
        }
        insert(target);

        // if (map.containsKey(key)) {
        //     remove(map.get(key));
        // }
        // Node newNode = new Node(key, value);
        // map.put(key, newNode);
        // insert(newNode);

        if (map.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }

    // Helper: Remove node from list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Insert at head (Most Recently Used)
    private void insert(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
}