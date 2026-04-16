class Solution {
    public int maxArea(int[] heights) {
        if (heights == null || heights.length < 2) return 0;
        int left = 0, right = heights.length-1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, Math.min(heights[left], heights[right]) * (right - left));
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
