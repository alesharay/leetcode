package com.aleshamray.easy.leastCommonAncestorOfBinarySearchTree;

public class App {
  public static void main(String[] args) {
    String[] arr = new String[]{"6","2","8","0","4","7","9",null,null,"3","5"};
    String[] arrP = new String[]{"2","0","4",null,null,"3","5"};
    String[] arrQ = new String[]{"8","7","9"};
    TreeNode result = getResult(arr, arrP, arrQ);
    System.out.printf("expected: 6 ; received: %d\n", result.val);

    arr = new String[]{"6","2","8","0","4","7","9",null,null,"3","5"};
    arrP = new String[]{"2","0","4",null,null,"3","5"};
    arrQ = new String[]{"4","3","5"};
    result = getResult(arr, arrP, arrQ);
    System.out.printf("expected: 2 ; received: %d\n", result.val);

    arr = new String[]{"2","1"};
    arrP = new String[]{"2","1"};
    arrQ = new String[]{"1"};
    result = getResult(arr, arrP, arrQ);
    System.out.printf("expected: 2 ; received: %d\n", result.val);


    arr = new String[]{"6","2","8","0","4","7","9",null,null,"3","5"};
    arrP = new String[]{"2","0","4",null,null,"3","5"};
    arrQ = new String[]{"9"};
    result = getResult(arr, arrP, arrQ);
    System.out.printf("expected: 6 ; received: %d\n", result.val);

    arr = new String[]{"6","2","8","0","4","7","9",null,null,"3","5"};
    arrP = new String[]{"3"};
    arrQ = new String[]{"5"};
    result = getResult(arr, arrP, arrQ);
    System.out.printf("expected: 4 ; received: %d\n", result.val);

    arr = new String[]{"6","2","8","0","4","7","9",null,null,"3","5"};
    arrP = new String[]{"0"};
    arrQ = new String[]{"9"};
    result = getResult(arr, arrP, arrQ);
    System.out.printf("expected: 6 ; received: %d\n", result.val);
  }

  public static TreeNode getResult(String[] arr, String[] arrP, String[] arrQ) {
    TreeNode root = createBST(arr);
    TreeNode p = createBST(arrP);
    TreeNode q = createBST(arrQ);
    TreeNode result = lowestCommonAncestor(root,p,q);
    return result;
  }

  public static TreeNode createBST(String[] arr) {
    if(arr == null || arr.length == 0) { return null; }
    
    TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
      
    for(String val : arr) {
      if(null == val) { continue; }
      if(root.val == Integer.parseInt(val)) { continue; }
      updateBST(Integer.parseInt(val), root);
    } 

    return root;
  }

  public static TreeNode updateBST(int num, TreeNode root) {
      // if character value is less than the current root value
      if(num < root.val) {  
        // if root left exists
        if(root.left != null) {
          // createBST to the left
          updateBST(num, root.left);
        }
        // otherwise
        else {
          // place character to the left
          root.left = new TreeNode(num);
        }
      }
      // if character is greater than the current root value
      else if(num > root.val) {
        // if root to the right exists
        if(root.right != null) {
          // create BST to the right
          updateBST(num, root.right);
        }
        // otherwise 
        else {
          // place character to the right
          root.right = new TreeNode(num);
        }
      }
    return root;
  }


  // public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

  //   if ( (root.val == p.val) || (root.val == q.val) ) {
  //     return root;
  //   } 
  //   else if ( ( (root.val > p.val) && (root.val < q.val) ) ||
  //             ( (root.val < p.val) && (root.val > q.val) ) ) {
  //     return root; 
  //   } else {
  //     TreeNode left = root.left != null ? lowestCommonAncestor(root.left, p, q) : null;
  //     TreeNode right = root.right != null ? lowestCommonAncestor(root.right, p, q) : null;
  
  //     if (left == null && right != null) return right;
  //     if (left != null && right == null) return left;
  //   }

  //   return null;
  // }


// Another User Solution (retrieved after solving with my solution above)
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) return null;
    
    if(root.val < p.val && root.val < q.val)
//             right call
        return lowestCommonAncestor(root.right, p, q);
    
    if(root.val > p.val && root.val > q.val)
//             left call
        return lowestCommonAncestor(root.left, p, q);
    
    return root;
    
}
}

/* 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 
 *             6
 *          /      \ 
 *      * 2         8 *
 *      /   \     /   \
 *    0      4   7     9
 *          / \
 *         3   5
 * 
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 
 *              6
 *          /       \ 
 *      * 2           8
 *      /   \       /   \
 *    0      4 *   7     9
 *          / \
 *         3   5
 * 
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: root = [2,1], p = 2, q = 1
 * 
 *    * 2
 *     /
 *  * 1
 * 
 * Output: 2
 *  
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [2, 105]
 * 
 * -109 <= Node.val <= 109
 * 
 * All Node.val are unique
 * 
 * p != q
 * 
 * p and q will exist in the BST
 * 
 * User constraints
 * 
 * p < q || p > q
 */