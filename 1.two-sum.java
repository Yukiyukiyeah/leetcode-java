/*
 * @Author: your name
 * @Date: 2020-12-30 12:01:59
 * @LastEditTime: 2020-12-30 12:48:16
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editpublic class 1.two-sum {
   
 }
 
 * @FilePath: /leetcode-java/1.two-sum.java
 */
import java.util.*;

class Solution {
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        return new int[]{map.get(nums[i]), i};
      } else {
        map.put(target - nums[i], i);
      }
    }
    return new int[0];
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    int target = 6;
    int[] res = twoSum(nums, target);
    System.out.println(Arrays.toString(res));
  }
}