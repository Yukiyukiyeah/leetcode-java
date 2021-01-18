/*
 * @Author: your name
 * @Date: 2021-01-18 23:16:19
 * @LastEditTime: 2021-01-18 23:16:21
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editpublic class 26.remove-duplicates-from-sorted-array {
   
 }
 
 * @FilePath: /leetcode-java/26.remove-duplicates-from-sorted-array.java
 */
class Solution {
  public int removeDuplicates(int[] nums) {
      int len = nums.length;
      int i = 0;
      for (int j = 1; j < len; j++) {
          if (nums[j] != nums[i]) {
              nums[i + 1] = nums[j];
              i++;
          }
      }
      return i + 1;
  }
}