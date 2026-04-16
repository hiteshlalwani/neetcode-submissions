class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null) return t == null;
        if (t == null) return s == null;
        if (s.length() != t.length()) return false;
        if (s.length() == 0) return true;

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            count1[s.charAt(i) - 'a']++;
            count2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < count1.length; ++i) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }
}
