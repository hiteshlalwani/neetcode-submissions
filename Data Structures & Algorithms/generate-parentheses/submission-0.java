class Solution {

    private final char[] allowedChars = {'(', ')'};

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        generateParenthesisRecur(0, n*2, new StringBuilder(), res);
        return res;
    }

    private void generateParenthesisRecur(int idx, int n, StringBuilder cur, List<String> res) {
        if (idx == n) {
            String str = cur.toString();
            if (isValidParenthesis(str)) res.add(str);
            return;
        }
        for (char c : allowedChars) {
            cur.append(c);
            generateParenthesisRecur(idx+1, n, cur, res);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    private boolean isValidParenthesis(String str) {
        if (str == null || str.length() == 0) return true;
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
