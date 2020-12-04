/*
 * @Author: your name
 * @Date: 2020-12-04 14:51:41
 * @LastEditTime: 2020-12-04 14:52:15
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/173.binary-search-tree-iterator2.java
 */
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
class BSTIterator {
  Stack<TreeNode> stack;
  
  public BSTIterator(TreeNode root) {
      this.stack =  new Stack<TreeNode>();
      this.leftmostInorder(root);
  }
  
  private void leftmostInorder(TreeNode root) {
      while (root != null) {
          this.stack.push(root);
          root = root.left;
      }
  }
  
  public int next() {
      TreeNode topmostNode = this.stack.pop();
      if (topmostNode.right != null) {
          this.leftmostInorder(topmostNode.right);
      }
      return topmostNode.val;
  }
  
  public boolean hasNext() {
      return this.stack.size() > 0;
  }
}

/**
* Your BSTIterator object will be instantiated and called as such:
* BSTIterator obj = new BSTIterator(root);
* int param_1 = obj.next();
* boolean param_2 = obj.hasNext();
*/