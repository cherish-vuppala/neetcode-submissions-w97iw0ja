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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        
        return isValidBSTUtil(root, null);
    }

    private boolean isValidBSTUtil(TreeNode root, TreeNode parent) {
        
        if (isLeafNode(root))
            return true;
        
        if (root.val <= root.left.val || root.val >= root.right.val)
            return false;
        
        if (parent != null && (parent.val <= root.left.val || parent.val >= root.right.val))
            return false;
        
        return isValidBSTUtil(root.left, root) && isValidBSTUtil(root.right, root);
    }

    public boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
