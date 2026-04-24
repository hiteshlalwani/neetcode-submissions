class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than the far right element, 
            // the minimum must be in the right half.
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            // Otherwise, the minimum is either at mid or to the left.
            else {
                high = mid;
            }
        }
        
        // When low == high, we've found the minimum element.
        return nums[low];
    }
}