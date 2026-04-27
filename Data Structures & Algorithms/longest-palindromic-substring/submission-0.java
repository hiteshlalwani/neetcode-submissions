class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int maxLen = 0;
        int start = -1;
        for (int i = 0; i < s.length(); ++i) {
            int len = maxLenPalindrome(s, i, i);
            if (len > maxLen) {
                maxLen = len;
                start = i - len/2;
            }
            if (i+1 < s.length()) {
                len = maxLenPalindrome(s, i, i+1);
                if (len > maxLen) {
                    maxLen = len;
                    start = i - (len-1)/2;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int maxLenPalindrome(String s, int left, int right) {
        if (s == null || s.length() == 0 || left > right) return 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }
}
