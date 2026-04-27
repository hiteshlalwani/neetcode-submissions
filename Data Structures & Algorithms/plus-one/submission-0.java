class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate from the last digit to the first
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If the digit is 9, it becomes 0 and we continue to the next index
            digits[i] = 0;
        }

        // If the loop finishes, it means all digits were 9 (e.g., [9, 9, 9])
        // We need a new array of size n + 1, starting with 1 (e.g., [1, 0, 0, 0])
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}