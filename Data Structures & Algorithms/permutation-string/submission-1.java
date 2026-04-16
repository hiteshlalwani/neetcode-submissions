class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // Build initial frequency map for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Count how many characters currently match in frequency
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) matches++;
        }

        // Slide the window across s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches == 26) return true;

            int r = s2.charAt(i + s1.length()) - 'a'; // Right side (entering)
            int l = s2.charAt(i) - 'a';               // Left side (leaving)

            // Update for the character entering the window
            s2Count[r]++;
            if (s1Count[r] == s2Count[r]) matches++;
            else if (s1Count[r] + 1 == s2Count[r]) matches--;

            // Update for the character leaving the window
            s2Count[l]--;
            if (s1Count[l] == s2Count[l]) matches++;
            else if (s1Count[l] - 1 == s2Count[l]) matches--;
        }

        return matches == 26;
    }
}