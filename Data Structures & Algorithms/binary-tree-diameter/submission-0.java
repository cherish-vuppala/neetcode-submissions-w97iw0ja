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
    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int leftGain = dfs(root.left);
        int rightGain = dfs(root.right);

        int currPath = leftGain + rightGain;
        diameter = Math.max(diameter, currPath);

        return Math.max(leftGain, rightGain) + 1;
    }
}
