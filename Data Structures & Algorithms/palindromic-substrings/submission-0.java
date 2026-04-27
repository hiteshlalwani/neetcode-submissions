class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindromes (center is at index i)
            count += expand(s, i, i);
            
            // Case 2: Even length palindromes (center is between i and i + 1)
            count += expand(s, i, i + 1);
        }
        return count;
    }

    private int expand(String s, int left, int right) {
        int currentCount = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            currentCount++;
            left--;
            right++;
        }
        return currentCount;
    }
}