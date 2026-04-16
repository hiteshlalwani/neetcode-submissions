class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n];
        int prod = 1;
        for (int i = 0; i < nums.length; ++i) {
            res[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for (int i = n-1; i >= 0; i--) {
            res[i] *= prod;
            prod *= nums[i];
        }
        return res;
    }
}  
