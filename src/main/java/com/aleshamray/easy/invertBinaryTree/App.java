package com.aleshamray.easy.invertBinaryTree;

/* 
 * Given the root of a binary tree, invert the tree, and return its root.
 *  
 * 
 * Example 1:
 * 
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * 
 * 
 * Example 2:
 * 
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * 
 * 
 * Example 3:
 * 
 * Input: root = []
 * Output: []
 *  
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

public class App {
  public static void main(String[] args) {
    // TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    // TreeNode root = new TreeNode(4, 
    //                 new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));

    TreeNode root = null;

    System.out.print("\n[");
    display(root);
    System.out.print(" ]\n\n");

    TreeNode result = App.invertTree(root);

    System.out.print("\n[");
    display(result);
    System.out.print(" ]\n\n");
  }

  public static void display(TreeNode root) {
    if (root == null) {
      return;
    }

    System.out.printf(" %d ", root.val);
    display(root.left);
    display(root.right);
    
  }

  public static TreeNode swap(TreeNode root) {
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    return root;
  }

  public static TreeNode invertTree(TreeNode root) {    

    if (root == null) return null;
    if (root.left == null && root.right == null) return root;
    
    root = swap(root);
    if (root.left != null) root.left = invertTree(root.left);
    if (root.right != null) root.right = invertTree(root.right);

    return root;
  }
}
