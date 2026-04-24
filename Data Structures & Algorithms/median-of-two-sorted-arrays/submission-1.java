class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return findMedianSingleSortedArray(nums2);
        if (nums2 == null || nums2.length == 0) return findMedianSingleSortedArray(nums1);
        int m = nums1.length;
        int n = nums2.length;
        int prev = 0;
        int cur = 0;

        int count = (m + n + 1)/2;

        int i = 0, j = 0;
        while (count-- >= 0) {
            prev = cur;
            if (i >= m) {
                cur = nums2[j++];
            } else if (j >= n) {
                cur = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                cur = nums1[i++];
            } else {
                cur = nums2[j++];
            }
        }
        System.out.println("cur = " + cur + ", prev = " + prev);
        return (m+n)%2 == 0 ? (prev + cur)/2.0 : prev;
    }

    private double findMedianSingleSortedArray(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length%2 == 1) {
            return nums[nums.length/2];
        } else {
            return (nums[nums.length/2] + nums[(nums.length-1)/2])/2.0;
        }
    }
}
