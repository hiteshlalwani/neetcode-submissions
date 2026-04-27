class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // This bitwise trick flips the least-significant 1-bit to 0
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}