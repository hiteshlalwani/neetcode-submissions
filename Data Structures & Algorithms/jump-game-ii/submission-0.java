class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int jumps = 0;
        int currentJumpEnd = 0; // The farthest index we can reach with 'jumps'
        int farthest = 0;        // The farthest index we can reach with 'jumps + 1'

        // We don't need to process the last element because we're already there
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the absolute farthest we can reach from the current index
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the range for our current jump level
            if (i == currentJumpEnd) {
                jumps++;             // We must take another jump
                currentJumpEnd = farthest; // Update the range for the next jump level

                // Optimization: if we can already reach the end, break early
                if (currentJumpEnd >= nums.length - 1) break;
            }
        }

        return jumps;
    }
}