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
    TreeNode node = null;
    int k = -1;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
       return node.val;
    }

    public void inorder(TreeNode root) {
        if (root == null || k == 0) return;
        
        inorder(root.left);
        k--;
        if (k == 0) {
            node = root;
            return;
        }
        
        inorder(root.right);
    } 
}
