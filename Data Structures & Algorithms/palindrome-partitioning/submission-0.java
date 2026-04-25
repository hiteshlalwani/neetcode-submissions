class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        partitionRecur(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void partitionRecur(String s, int pos, List<String> cur, List<List<String>> res) {
        if (pos >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int idx = pos; idx < s.length(); ++idx) {
            sb.append(s.charAt(idx));
            if (isPalindrome(sb)) {
                String str = sb.toString();
                cur.add(str);
                partitionRecur(s, idx+1, cur, res);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isPalindrome(StringBuilder s) {
        if (s == null || s.length() < 2) return true;
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
