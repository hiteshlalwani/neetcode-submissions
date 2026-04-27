class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        
        Set<String> words = new HashSet<>();
        int n = s.length();
        int minLen = n;
        for (String word : wordDict) {
            if (word.length() < minLen) {
                minLen = word.length();
            }
            words.add(word);
        }

        if (n < minLen) return false;
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;   // empty string can be split always

        for (int i = minLen; i <= n; ++i) {
            for (int j = i-minLen; j >= 0; j--) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
