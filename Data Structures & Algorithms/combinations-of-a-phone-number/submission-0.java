class Solution {
    // Mapping of digits to their corresponding letters
    private String[] mapping = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> res) {
        // Base case: we've processed all digits
        if (index == digits.length()) {
            res.add(current.toString());
            return;
        }

        // Get the letters for the current digit
        String letters = mapping[digits.charAt(index) - '0'];
        
        for (char c : letters.toCharArray()) {
            // 1. Choose: add a letter
            current.append(c);
            
            // 2. Explore: move to the next digit
            backtrack(digits, index + 1, current, res);
            
            // 3. Un-choose: remove the letter (backtrack)
            current.deleteCharAt(current.length() - 1);
        }
    }
}