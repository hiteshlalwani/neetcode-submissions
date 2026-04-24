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

    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            this.inorderMap.put(inorder[i], i);
        }
        return buildTreeRecur(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTreeRecur(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        }
        int val = preorder[preStart];
        int idx = findIndexInInorder(val);
        int countLeft = idx - inStart;
        TreeNode root = new TreeNode(val);
        root.left = buildTreeRecur(preorder, preStart + 1, preStart + countLeft, inorder, inStart, idx-1);
        root.right = buildTreeRecur(preorder, preStart + countLeft + 1, preEnd, inorder, idx+1, inEnd);
        return root;
    }

    private int findIndexInInorder(int val) {
        return this.inorderMap.get(val);
    }
}
