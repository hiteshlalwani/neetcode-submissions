class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // Treat as ')'
                maxOpen++; // Treat as '('
            }

            // If maxOpen is negative, even with all stars as '(', it's invalid
            if (maxOpen < 0) return false;

            // minOpen cannot be less than 0 (we can't have "negative" open parens)
            if (minOpen < 0) minOpen = 0;
        }

        // For the string to be valid, we must be able to end with exactly 0 open parens
        return minOpen == 0;
    }
}