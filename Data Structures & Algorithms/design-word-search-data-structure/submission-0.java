class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode cur) {
        // Base case: we've reached the end of the word
        if (index == word.length()) {
            return cur.isWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            // Wildcard logic: try all 26 possible children
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    if (dfs(word, index + 1, cur.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            // Standard Trie search logic
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            return dfs(word, index + 1, cur.children[idx]);
        }
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
}