/*
 * @Author: your name
 * @Date: 2020-12-16 12:32:54
 * @LastEditTime: 2020-12-16 12:34:03
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/J26.java
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
// 可能有重复元素，不能简单根据A.val == B.val来进行isSame判断
// 可能有B匹配结束，但A没有匹配结束的情况
class Solution {
  public boolean isSubStructure(TreeNode A, TreeNode B) {
      if (A == null || B == null) return false;
      return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
  }
  private boolean isSame(TreeNode A, TreeNode B) {
      if (B == null) return true;
      else if (A == null || A.val != B.val) return false;
      return isSame(A.left, B.left) && isSame(A.right, B.right);
  }
}