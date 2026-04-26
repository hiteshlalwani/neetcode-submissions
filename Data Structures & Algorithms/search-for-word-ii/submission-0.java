class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Store the actual word at the leaf to avoid StringBuilders
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for (char c : w.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.word = w; // Mark the end of a word by storing the word itself
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char c = board[i][j];
        // 1. Pruning: Stop if we hit a visited cell or a character not in our Trie path
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];
        // 2. Found a word!
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // IMPORTANT: De-duplicate so we don't find the same word twice
        }

        board[i][j] = '#'; // Mark as visited (no separate visited array needed)
        
        // 3. Standard DFS in 4 directions
        if (i > 0) dfs(board, i - 1, j, node, res);
        if (j > 0) dfs(board, i, j - 1, node, res);
        if (i < board.length - 1) dfs(board, i + 1, j, node, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, res);

        board[i][j] = c; // Backtrack: Restore the character
    }
}