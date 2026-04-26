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

    // private Map<String, Boolean> memo = new HashMap<>();

    // public boolean searchWithStar(String word, String pattern) {
    //     return dfs(word, 0, pattern, 0, root);
    // }

    // private boolean dfs(String word, int wIdx, String pattern, int pIdx, TrieNode cur) {
    //     String key = wIdx + "," + pIdx + "," + cur.hashCode();
    //     if (memo.containsKey(key)) return memo.get(key);

    //     // Base Case: reached end of pattern
    //     if (pIdx == pattern.length()) {
    //         return cur.isWord; // Word is valid only if we're at a leaf
    //     }

    //     char p = pattern.charAt(pIdx);
    //     boolean match = false;

    //     if (p == '*') {
    //         // Option 1: Match ZERO characters (skip the star)
    //         match = dfs(word, wIdx, pattern, pIdx + 1, cur);

    //         // Option 2: Match ONE or MORE characters
    //         if (!match) {
    //             for (int i = 0; i < 26; i++) {
    //                 if (cur.children[i] != null) {
    //                     // Stay on pIdx (the star) but move to the next Trie node
    //                     if (dfs(word, wIdx, pattern, pIdx, cur.children[i])) {
    //                         match = true;
    //                         break;
    //                     }
    //                 }
    //             }
    //         }
    //     } else {
    //         // Standard matching (same as your current . logic)
    //         // ...
    //     }

    //     memo.put(key, match);
    //     return match;
    // }
}