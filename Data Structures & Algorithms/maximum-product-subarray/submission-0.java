class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxProd = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int prod = 1;
            for (int j = i; j < nums.length; ++j) {
                prod *= nums[j];
                maxProd = Math.max(prod, maxProd);
            }
        }
        return maxProd;
    }
}
