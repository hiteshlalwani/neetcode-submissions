class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 1;
        Map<Character, Integer> idxMap = new HashMap<>();

        int start = 0, end = 0;
        while (end < s.length()) {
            if (idxMap.containsKey(s.charAt(end))) {
                start = Math.max(start, idxMap.get(s.charAt(end)) + 1);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            idxMap.put(s.charAt(end), end);
            end++;
        }
        return maxLen;
    }
}
