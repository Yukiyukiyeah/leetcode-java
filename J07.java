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
      Map<Integer, Integer> inMap = new HashMap<>();
      int len = inorder.length;
      for (int i = 0; i < len; i++) {
          inMap.put(inorder[i], i);
      }
      return buildTree(preorder, inorder, 0, len - 1, 0, len - 1, inMap);
  }
  private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> inMap) {
      if (preStart > preEnd || inStart > inEnd) return null;
      TreeNode root = new TreeNode(preorder[preStart]);
      int rootPos = inMap.get(root.val);
      int numsLeft = rootPos - inStart;
      root.left = buildTree(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, rootPos - 1, inMap);
      root.right = buildTree(preorder, inorder, preStart + numsLeft + 1, preEnd, rootPos + 1, inEnd, inMap);
      return root;
  }
}
