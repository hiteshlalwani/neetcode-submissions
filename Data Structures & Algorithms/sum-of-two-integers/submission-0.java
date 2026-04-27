class Solution {
    public int getSum(int a, int b) {
        // Continue until there is no carry left
        while (b != 0) {
            // 1. Calculate the carry
            // A carry is generated only if both bits are 1 (1 & 1 = 1)
            int carry = (a & b) << 1;

            // 2. Calculate the sum without carry
            // XOR acts as addition for single bits (0+1=1, 1+0=1, 0+0=0, 1+1=0)
            a = a ^ b;

            // 3. Set b to the carry to add it in the next iteration
            b = carry;
        }
        return a;
    }
}