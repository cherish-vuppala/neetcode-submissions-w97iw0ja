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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) { 
        var node = search(root, subRoot);
        
        return isSubTreeUtil(root, subRoot);
    }

    private TreeNode search(TreeNode root, TreeNode node) {
        if (root == null)
            return root;
        
        if (root.val == node.val)
            return root;
        
        var left = search(root.left, node);
        var right = search(root.right, node);

        return left != null ? left : right;

    }

    private boolean isSubTreeUtil(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;
        
        if (r2 == null)
            return true;
        
        if ((r1 == null && r2 != null) || (r1.val != r2.val))
            return false;
        
        return isSubTree(r1.left, r2.left) && isSubTree(r1.right, r2.right);
    }
}
