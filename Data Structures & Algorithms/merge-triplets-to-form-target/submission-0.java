class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // We track which of the three target values we've successfully matched
        boolean resX = false, resY = false, resZ = false;

        for (int[] t : triplets) {
            // Step 1: Discard triplets that have ANY value exceeding the target
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }

            // Step 2: For valid triplets, check if they help us reach the target values
            if (t[0] == target[0]) resX = true;
            if (t[1] == target[1]) resY = true;
            if (t[2] == target[2]) resZ = true;

            // Optimization: If all three are found, we can stop early
            if (resX && resY && resZ) return true;
        }

        return resX && resY && resZ;
    }
}