class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        
        // XORing a number with itself results in 0 (x ^ x = 0)
        // XORing a number with 0 results in the number itself (x ^ 0 = x)
        for (int n : nums) {
            res ^= n;
        }
        
        // Because XOR is commutative and associative, the order doesn't matter.
        // All pairs will cancel each other out, leaving only the single number.
        return res;
    }
}