class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        
        // 1. Build the Trie
        for (String word : wordDict) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.isEndOfWord = true;
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // 2. DP with Trie Traversal
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue; // Only start searching from valid break points

            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                if (curr.children[idx] == null) break; // Optimization: No word exists with this prefix

                curr = curr.children[idx];
                if (curr.isEndOfWord) {
                    dp[j + 1] = true;
                }
            }
        }

        return dp[n];
    }
}