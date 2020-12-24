/*
 * @Author: your name
 * @Date: 2020-12-17 19:55:52
 * @LastEditTime: 2020-12-24 14:22:11
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/3.longest-substring-without-repeating-characters.java
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        char[] s2 = s.toCharArray();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s2[right];
            if (window.containsKey(c)) {
                left = Math.max(left, window.get(c) + 1);
            }
            window.put(c, right);
            right ++;
            res = Math.max(res, right - left);
        }
        return res;
    }
}