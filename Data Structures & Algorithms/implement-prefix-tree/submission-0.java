class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new TrieNode();
            }
            cur = cur.child[idx];
        }
        cur.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.child[idx] == null) return false;
            cur = cur.child[idx];
        }
        return cur.wordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (cur.child[idx] == null) return false;
            cur = cur.child[idx];
        }
        return true;
    }

    private static class TrieNode {
        TrieNode[] child;
        boolean wordEnd;

        public TrieNode() {
            this.child = new TrieNode[26];
            this.wordEnd = false;
        }
    }
}