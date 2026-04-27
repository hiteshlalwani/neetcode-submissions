class Solution {
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            // Extract the last digit
            int digit = x % 10;
            // Move x to the next digit
            x /= 10;

            // Check for Overflow before updating res
            // Integer.MAX_VALUE is 2147483647
            if (res > Integer.MAX_VALUE / 10 || 
               (res == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            
            // Check for Underflow before updating res
            // Integer.MIN_VALUE is -2147483648
            if (res < Integer.MIN_VALUE / 10 || 
               (res == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            // Append digit to the result
            res = (res * 10) + digit;
        }

        return res;
    }
}