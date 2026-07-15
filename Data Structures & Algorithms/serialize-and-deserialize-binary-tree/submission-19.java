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
        int i = 0;
        for (int x: preorder){
            i++;
            sb.append(x);
            if (i <= preorder.size()-1)
                sb.append(" ");
        }

        sb.append("#");
        i = 0;
        for (int x: inorder){
            i++;
            sb.append(x);
             if (i <= inorder.size()-1)
                sb.append(" ");
        }

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0 || data.isEmpty())
            return null;
        String[] arr = data.split("#");

        System.out.println("arr" + Arrays.toString(arr));

        var preorderArr = arr[0].split(" ");
        var inorderArr = arr[1].split(" ");

        System.out.println(Arrays.toString(preorderArr));
        System.out.println(Arrays.toString(inorderArr));

        return constructTree(preorderArr, inorderArr);
    }

    public TreeNode constructTree(String[] preorderArr, String[] inorderArr) {
        
        for (int i = 0; i < inorderArr.length; i++)
            inorderMap.put(Integer.parseInt(inorderArr[i]), i);
        
        System.out.println(inorderMap);
        
        return buildTree(preorderArr, 0, inorderArr.length-1);
    }

    private TreeNode buildTree(String[] preorderArr,int left, int right) {
        if (left > right)
            return null;
        
        System.out.println("preorderIndex: " + preorderIndex);
        System.out.println("left: " + left);
        System.out.println("right: " + right);

        int rootValue = Integer.parseInt(preorderArr[preorderIndex]);
        System.out.println("rootValue: " + rootValue);

        int inorderIndex = inorderMap.get(rootValue);
        System.out.println("inorderIndex: " + inorderIndex);

        TreeNode root = new TreeNode(rootValue);
        preorderIndex++;

        root.left = buildTree(preorderArr, left, inorderIndex-1);
        root.right = buildTree(preorderArr, inorderIndex+1, right);

        

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
