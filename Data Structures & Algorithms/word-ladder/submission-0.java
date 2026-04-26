class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null && endWord == null) return 0;
        if (beginWord == null || endWord == null || wordList == null) return 0;
        
        Set<String> words = new HashSet<>(wordList);
        
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        
        int level = 1;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while (!q.isEmpty() && !words.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                char[] arr = cur.toCharArray();
                for (int i = 0; i < arr.length; ++i) {
                    char oldChar = arr[i];
                    for (int j = 0; j < 26; ++j) {
                        char nextChar = (char)('a' + j);
                        if (nextChar == oldChar) continue;
                        arr[i] = nextChar;
                        String nextStr = new String(arr);
                        if (words.contains(nextStr)) {
                            if (nextStr.equals(endWord)) {
                                return level + 1;
                            }
                            q.offer(nextStr);
                            words.remove(nextStr);
                        }
                        arr[i] = oldChar;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
