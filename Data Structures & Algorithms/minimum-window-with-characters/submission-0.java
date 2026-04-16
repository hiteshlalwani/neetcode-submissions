class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() == 0 || t.length() > s.length()) return "";
        
        int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int left = 0, right = 0;
        int lenMatch = 0;
        int minStart = -1;
        int minLen = s.length() + 1;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (count[c]-- > 0) {
                lenMatch++;
            }
            while (lenMatch == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                if (++count[s.charAt(left)] > 0) {
                    lenMatch--;
                }
                left++;
            }
            right++;
        }
        return (minStart >= 0) ? s.substring(minStart, minStart + minLen) : "";

    }
}
