class Solution {
    public double myPow(double x, int n) {
        // Base case: any number to the power of 0 is 1
        if (n == 0) return 1.0;

        // Handle negative exponents: x^-n = (1/x)^n
        // We use a long for 'num' to avoid overflow when n is Integer.MIN_VALUE
        long num = n;
        if (num < 0) {
            x = 1 / x;
            num = -num;
        }

        return helper(x, num);
    }

    private double helper(double x, long n) {
        if (n == 0) return 1.0;

        // Recursively calculate half the power
        double half = helper(x, n / 2);

        if (n % 2 == 0) {
            // If n is even: x^n = x^(n/2) * x^(n/2)
            return half * half;
        } else {
            // If n is odd: x^n = x * x^(n/2) * x^(n/2)
            return x * half * half;
        }
    }
}