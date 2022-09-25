package com.aleshamray.easy.balancedBinaryTree;

public class App {
  
  public static void main(String[] args) {
    Integer[] tree = new Integer[]{3,9,20,null,null,15,7};
    TreeNode root = getTree(tree, null);
    
  }

  private static TreeNode getTree(Integer[] tree, TreeNode root) {


    // TODO: address for when val is null

    for(Integer val : tree) {
      if (root == null) { root = new TreeNode(val); }
      else {
        if (root.left == null) { root.left = new TreeNode(val); }
        else if (root.right == null) { root.right = new TreeNode(val); }
        else {
          getTree(tree, root.left);
          getTree(tree, root.right);
        }
      }
    }

    return root;
  }

  public static boolean isBalanced(TreeNode root) {
    return false;
  }
}
