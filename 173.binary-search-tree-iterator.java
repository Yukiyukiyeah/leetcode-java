/*
 * @Author: your name
 * @Date: 2020-12-04 14:40:42
 * @LastEditTime: 2020-12-04 14:40:42
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/173.binary-search-tree-iterator.java
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
  ArrayList<Integer> nodeSorted;
  int index;
  
  public BSTIterator(TreeNode root) {
      this.nodeSorted = new ArrayList<Integer>();
      this.index = -1;
      inorder(root);
  }
  
  private void inorder(TreeNode root) {
      if (root == null) return;
      inorder(root.left);
      this.nodeSorted.add(root.val);
      inorder(root.right);
  }
  
  public int next() {
      this.index += 1;
      return this.nodeSorted.get(this.index);
  }
  
  public boolean hasNext() {
      return this.index + 1  < this.nodeSorted.size();
  }
}

/**
* Your BSTIterator object will be instantiated and called as such:
* BSTIterator obj = new BSTIterator(root);
* int param_1 = obj.next();
* boolean param_2 = obj.hasNext();
*/