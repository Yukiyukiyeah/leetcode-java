/*
 * @Author: your name
 * @Date: 2021-01-06 21:22:53
 * @LastEditTime: 2021-01-06 21:22:55
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/20.valid-parentheses.java
 */
class Solution {
  public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      Map<Character, Character> map = new HashMap<>(){{
          put('}', '{');
          put(')', '(');
          put(']', '[');
      }};
      char[] sArr = s.toCharArray();
      for (int i = 0; i < sArr.length; i++) {
          if (!map.containsKey(sArr[i])) {
              stack.push(sArr[i]);
          } else if(stack.isEmpty() || stack.pop() != map.get(sArr[i])) {
              return false;
          }
      }
      return stack.isEmpty();
  }
}
