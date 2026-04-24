/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] maxPathSumRef = {root.val};
        getMaxFaillingPathSumRecur(root, maxPathSumRef);
        return maxPathSumRef[0];
    }

    private int getMaxFaillingPathSumRecur(TreeNode root, int[] maxPathSumRef) {
        if (root == null) return 0;
        int left = Math.max(0, getMaxFaillingPathSumRecur(root.left, maxPathSumRef));
        int right = Math.max(0, getMaxFaillingPathSumRecur(root.right, maxPathSumRef));
        maxPathSumRef[0] = Math.max(maxPathSumRef[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
