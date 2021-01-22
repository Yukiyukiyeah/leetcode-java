/*
 * @Author: your name
 * @Date: 2021-01-22 22:21:49
 * @LastEditTime: 2021-01-22 22:21:54
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/299.bulls-and-cows.java
 */
public class 299.bulls-and-cows {
  
}
class Solution {
  public String getHint(String secret, String guess) {
      int[] array = new int[10];
      int A = 0, B = 0;
      for (int i = 0; i < secret.length(); i++) {
          if (secret.charAt(i) == guess.charAt(i)) {
              A++;
          }
          else {
              if (array[secret.charAt(i) - '0'] < 0) {
                  B++;
              }
              if (array[guess.charAt(i) - '0'] > 0) {
                  B++;
              }
              array[secret.charAt(i) - '0']++;
              array[guess.charAt(i) - '0']--;
          }
      }
      StringBuilder s = new StringBuilder();
      return s.append(A).append('A').append(B).append('B').toString();
  }
}