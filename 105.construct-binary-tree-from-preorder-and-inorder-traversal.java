/*
 * @Author: your name
 * @Date: 2020-12-11 15:08:25
 * @LastEditTime: 2020-12-11 15:08:56
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/105.construct-binary-tree-from-preorder-and-inorder-traversal.java
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
      HashMap<Integer, Integer> inMap = new HashMap<>();
      int len = preorder.length;
      for (int i = 0; i < len; i++) {
          inMap.put(inorder[i], i);
      }
      return buildTree(preorder, 0, len - 1, inorder, 0, len - 1, inMap);
  }
  private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap) {
      if (preStart > preEnd || inStart > inEnd) return null;
      TreeNode root = new TreeNode(preorder[preStart]);
      int rootPos = inMap.get(root.val);
      int numsLeft = rootPos - inStart;
      root.left =  buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, rootPos - 1, inMap);
      root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, rootPos + 1, inEnd, inMap);
      return root;
  }
}