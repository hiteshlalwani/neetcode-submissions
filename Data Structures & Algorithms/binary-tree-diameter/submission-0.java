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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        getMaxFallingHeight(root, res);
        return res[0] - 1;
    }

    private int getMaxFallingHeight(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = getMaxFallingHeight(root.left, res);
        int right = getMaxFallingHeight(root.right, res);
        res[0] = Math.max(res[0], 1 + left + right);
        return 1 + Math.max(left, right);
    }
}
