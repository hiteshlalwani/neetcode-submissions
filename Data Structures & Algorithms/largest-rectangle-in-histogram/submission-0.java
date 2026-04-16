class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int[] leftSmaller = new int[n];
        leftSmaller[0] = -1;
        for (int i = 1; i < n; ++i) {
            int left = i-1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left = leftSmaller[left];
            }
            leftSmaller[i] = left;
        }

        int[] rightSmaller = new int[n];
        rightSmaller[n-1] = n;
        for (int i = n-2; i >= 0; --i) {
            int right = i+1;
            while (right < n && heights[right] >= heights[i]) {
                right = rightSmaller[right];
            }
            rightSmaller[i] = right;
        }

        int maxArea = 0;

        for (int i = 0; i < n; ++i) {
            int area = heights[i] * (rightSmaller[i] - leftSmaller[i] - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
