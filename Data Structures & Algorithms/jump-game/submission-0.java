class Solution {
    public boolean canJump(int[] nums) {
        // Start the goal at the very last index
        int goal = nums.length - 1;

        // Iterate backwards from the second-to-last element to the start
        for (int i = nums.length - 2; i >= 0; i--) {
            // If the current position plus the max jump can reach the goal
            if (i + nums[i] >= goal) {
                // Move the goal to the current position
                goal = i;
            }
        }

        // If the goal post reached the starting index, the last index is reachable
        return goal == 0;
    }
}

// class Solution {
//     public boolean canJump(int[] nums) {
//         int maxReach = 0;
        
//         for (int i = 0; i < nums.length; i++) {
//             // If the current index is beyond our max possible reach, we are stuck
//             if (i > maxReach) {
//                 return false;
//             }
            
//             // Update the farthest we can reach from this point
//             maxReach = Math.max(maxReach, i + nums[i]);
            
//             // Optimization: if we can already reach the last index, stop early
//             if (maxReach >= nums.length - 1) {
//                 return true;
//             }
//         }
        
//         return true;
//     }
// }