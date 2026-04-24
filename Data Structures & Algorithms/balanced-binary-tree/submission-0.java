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
    public boolean isBalanced(TreeNode root) {
        return heightDiffRecur(root) >= 0;
    }

    private int heightDiffRecur(TreeNode root) {
        if (root == null) return 0;
        int left = heightDiffRecur(root.left);
        if (left < 0) return -1;
        int right = heightDiffRecur(root.right);
        if (right < 0) return -1;
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}
