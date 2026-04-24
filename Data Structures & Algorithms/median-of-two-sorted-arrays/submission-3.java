class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the shorter array for O(log(min(m, n)))
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            // i is the cut point in nums1 (number of elements on the left)
            int i = (low + high) / 2;
            // j is the cut point in nums2, calculated to keep the total left half equal
            int j = (m + n + 1) / 2 - i;

            // Boundary values: 
            // If i is 0, nothing is on the left from nums1; use -Infinity.
            // If i is m, nothing is on the right from nums1; use +Infinity.
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Condition A: left side of nums1 must be <= right side of nums2
            // Condition B: left side of nums2 must be <= right side of nums1
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // We found the perfect cut!
                if ((m + n) % 2 == 0) {
                    // Even total length: average of the two middle elements
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // Odd total length: the middle element is the max of the left side
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // nums1's left side is too big, move the cut 'i' to the left
                high = i - 1;
            } else {
                // nums1's left side is too small, move the cut 'i' to the right
                low = i + 1;
            }
        }
        return 0.0;
    }
}