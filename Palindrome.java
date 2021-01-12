/*
 * @Author: your name
 * @Date: 2021-01-12 14:18:12
 * @LastEditTime: 2021-01-12 15:22:28
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/Palindrome.java
 */
// 14:18 - 14:32 - 14:37 - 14:50
import java.util.*;

class Palindrome{
  public static boolean isPalindrome(String str) {
    char[] sArr = str.toCharArray();
    int len = sArr.length;
    int start = (len - 1) / 2;
    if (len % 2 == 0) {
      return isPalindrome(sArr, start, start + 1);
    } else {
      return isPalindrome(sArr, start, start);
    }
  }

  private static boolean isPalindrome(char[] s, int start, int end) {
    while (start >= 0 && end < s.length) {
      if (s[start] == s[end]) {
        start--;
        end++;
      }
      else return false;
    }
    return true;
  }

  public static boolean isPalindromeRecursive(String str) {
    if (str.length() <= 1) return true;
    if (str.length() == 2) return str.charAt(0) == str.charAt(1);
    return isPalindromeRecursive(str.substring(1, str.length() - 1));
  }

  public static List<Integer> repetitiveChar(String str) {
    List<Integer> res = new ArrayList<>();
    char[] sArr = str.toCharArray();
    int maxValue = 1;
    char maxChar = ' ';
    int curr = 1;
    for (int i = 1; i < sArr.length; i++) {
      if (sArr[i] ==  sArr[i - 1]) {
        curr ++;
      } else {
        curr = 1;
      }
      if (curr > maxValue) {
        maxValue = curr;
        maxChar = sArr[i];
      }
    }
    res.add(maxChar - '0');
    res.add(maxValue);
    return res;
  }

  public static void main(String[] args) {
    String str1 = "waw";
    String str2 = "waaw";
    String str3 = "wabw";
    System.out.println(isPalindrome(str1));
    System.out.println(isPalindrome(str2));
    System.out.println(isPalindrome(str3));
    System.out.println(isPalindromeRecursive(str1));
    System.out.println(isPalindromeRecursive(str2));
    System.out.println(isPalindromeRecursive(str3));
    String str4 =  "22222444431123";
    System.out.println(repetitiveChar(str4));
  }
}