class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (k >= s.length() - 1) return s.length();
        int[] count = new int[26];
        int start = 0, end = 0;
        int maxFreq = 1;
        int res = 1;
        while (end < s.length()) {
            int charIdx = s.charAt(end) - 'A';
            count[charIdx]++;
            maxFreq = Math.max(maxFreq, count[charIdx]);
            while (end - start + 1 - maxFreq > k) {
                int startIdx = s.charAt(start) - 'A';
                count[startIdx]--;
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
