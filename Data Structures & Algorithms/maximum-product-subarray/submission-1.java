class Solution {
    public int maxProduct(int[] nums) {
        int maxProdEnd = 1;
        int minProdEnd = 1;
        int maxProd = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                maxProdEnd = Math.max(nums[i], maxProdEnd*nums[i]);
                minProdEnd = Math.min(minProdEnd*nums[i], nums[i]);
            }
            else {
                int oldMaxProdEnd = maxProdEnd;
                maxProdEnd = Math.max(nums[i], minProdEnd*nums[i]);
                minProdEnd = Math.min(nums[i], oldMaxProdEnd*nums[i]);
            }
            maxProd = Math.max(maxProd, maxProdEnd);
        }
        return maxProd;
    }
}