class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Min is definitely in the right half
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                // Min is at mid or in the left half
                high = mid;
            } else {
                // nums[mid] == nums[high]
                // We don't know which side to go, so just shrink the window
                high--;
            }
        }
        return nums[low];
    }
}