class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null) return s2 == null;
        if (s2 == null) return false;
        if (s1.length() == 0) return true;
        if (s2.length() < s1.length()) return false;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c-'a']++;
        }

        int lenMatch = 0;

        int left = 0, right = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            if (count[c-'a']-- > 0) {
                lenMatch++;
            }

            if (right - left + 1 == s1.length()) {
                if (lenMatch == s1.length()) return true;
                if (++count[s2.charAt(left) - 'a'] > 0) {
                    lenMatch--;
                }
                left++;
            }

            right++;
        }
        return false;
    }
}
