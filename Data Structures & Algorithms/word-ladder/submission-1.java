class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1; // Start at 1 because the sequence includes beginWord

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) return level;

                char[] arr = cur.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char oldChar = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == oldChar) continue;
                        arr[j] = c;
                        String nextStr = new String(arr);

                        if (words.contains(nextStr)) {
                            q.offer(nextStr);
                            words.remove(nextStr); // Mark as visited
                        }
                    }
                    arr[j] = oldChar; // Backtrack character
                }
            }
            level++;
        }
        return 0;
    }
}