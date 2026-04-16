class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) return true;
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (right > left && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)) ) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
