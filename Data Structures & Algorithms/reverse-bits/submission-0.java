public class Solution {
    // Treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        
        for (int i = 0; i < 32; i++) {
            // 1. Extract the i-th bit of n
            // (n >> i) moves the target bit to the rightmost position
            // & 1 isolates that bit
            int bit = (n >> i) & 1;
            
            // 2. Place the extracted bit at its reversed position (31 - i)
            // We use OR (|) to set the bit in our result
            res = res | (bit << (31 - i));
        }
        
        return res;
    }
}