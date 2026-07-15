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

public class Codec {

    List<Integer> preorder = new ArrayList<>();
    List<Integer> inorder = new ArrayList<>();

    String preorderStr = "";
    String inorderStr = "";

    Map<Integer, Integer> inorderMap = new HashMap<>();
    int preorderIndex = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        preorderTraversal(root);
        inorderTraversal(root);

        StringBuilder sb = new StringBuilder();
        for (int x: preorder){
            sb.append(x);
        }

        sb.append("#");

        for (int x: inorder){
            sb.append(x);
        }

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0 || data.isEmpty())
            return null;
        String[] arr = data.split("#");

        this.preorderStr = arr[0];
        this.inorderStr = arr[1];

        return constructTree();
    }

    public TreeNode constructTree() {
        
        for (int i = 0; i < inorderStr.length(); i++)
            inorderMap.put(inorderStr.charAt(i) - '0', i);
        
        return buildTree(0, inorderStr.length()-1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right)
            return null;
        

        
        System.out.println("preorderIndex: " + preorderIndex);
        System.out.println("left: " + left);
        System.out.println("right: " + right);

        int rootValue = (preorderStr.charAt(preorderIndex) - '0');
        System.out.println("rootValue: " + rootValue);
        int inorderIndex = inorderMap.get(rootValue);
        System.out.println("inorderIndex: " + inorderIndex);
        TreeNode root = new TreeNode(rootValue);

        preorderIndex++;
        root.left = buildTree(left, inorderIndex-1);
        root.right = buildTree(inorderIndex+1, right);
        return root;
    }

    public void preorderTraversal(TreeNode root) {
        if (root == null)
            return;
        
        preorder.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public void inorderTraversal(TreeNode root) {
         if (root == null)
            return;
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }
}
