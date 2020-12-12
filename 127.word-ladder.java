/*
 * @Author: your name
 * @Date: 2020-12-12 17:05:13
 * @LastEditTime: 2020-12-12 19:57:53
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/127.word-ladder.java
 */
class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      if (wordList.size() == 0 || !wordList.contains(endWord)) return 0;
      Set<String> wordSet = new HashSet<>();
      for (String s: wordList) {
          wordSet.add(s);
      }
      Set<String> visited = new HashSet<>();
      Queue<String> q = new LinkedList<>();
      q.offer(beginWord);
      visited.add(beginWord);
      int length = 1;
      while (!q.isEmpty()) {
          int sz = q.size();
          for (int i = 0; i < sz; i ++) {
              String cur = q.poll();
              char[] ch = cur.toCharArray();
              for (int j = 0; j < cur.length(); j++) {
                  char originChar = ch[j];
                  for (char c = 'a'; c <= 'z'; c++) {
                      if (c == originChar) continue;
                      ch[j] = c;
                      String nextWord = new String(ch);
                      if (wordSet.contains(nextWord)) {
                          if (nextWord.equals(endWord)) {
                              return length + 1;
                          }
                          if (!visited.contains(nextWord)) {
                              q.offer(nextWord);
                              visited.add(nextWord);
                          }
                      }
                  }
                  ch[j] = originChar;
              }
          }
          length ++;
      }
      return 0;
  }
}