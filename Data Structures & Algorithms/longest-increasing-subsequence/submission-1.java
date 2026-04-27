class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        // tails[i] is the smallest ending element of an increasing subsequence of length i + 1
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = 0, j = size;
            // Binary search to find the insertion point for x
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            // Replace or extend the tails array
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }
}