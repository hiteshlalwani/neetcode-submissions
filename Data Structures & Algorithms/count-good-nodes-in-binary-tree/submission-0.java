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
    public int goodNodes(TreeNode root) {
        int[] countRef = new int[1];
        updateGoodNodesRecur(root, Long.MIN_VALUE, countRef);
        return countRef[0];
    }

    private void updateGoodNodesRecur(TreeNode root, long maxVal, int[] countRef) {
        if (root == null) return;
        if (root.val >= maxVal) {
            maxVal = root.val;
            countRef[0]++;
        }
        updateGoodNodesRecur(root.left, maxVal, countRef);
        updateGoodNodesRecur(root.right, maxVal, countRef);
    }
}
