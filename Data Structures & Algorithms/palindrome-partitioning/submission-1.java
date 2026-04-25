class Solution {
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        partitionRecur(s, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void partitionRecur(String s, int pos, List<String> cur, List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            // Instead of a StringBuilder, check the range (pos to i)
            if (isPalindrome(s, pos, i)) {
                cur.add(s.substring(pos, i + 1));
                partitionRecur(s, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
