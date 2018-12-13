package algorithm;


import java.util.HashMap;


public class Problem_105 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x;

          }
      }
    private HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0; i < preorder.length; i++)
            for(int j = 0; j < inorder.length; j++)
                if(preorder[i] == inorder[j])
                    map.put(preorder[i], j);
        return f(preorder, 0, 0, inorder.length-1);
    }
    private TreeNode f(int[] preorder, int rootIndex, int left,
                       int right){
        if(left > right)
            return null;
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int index = map.get(root.val);
        TreeNode leftChild = f(preorder, rootIndex+1, left, index-1);
        TreeNode rightChild = f(preorder, index-left+rootIndex+1, index+1, right);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = new Problem_105().buildTree(preorder, inorder);
        System.out.println(root.val);
    }
}
