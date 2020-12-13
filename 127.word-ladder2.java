/*
 * @Author: your name
 * @Date: 2020-12-12 17:47:41
 * @LastEditTime: 2020-12-12 20:08:25
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/127.word-ladder2.java
 */
class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      if (wordList.size() == 0 || !wordList.contains(endWord)) return 0;
      Set<String> wordSet = new HashSet<>();
      for (String s: wordList) {
          wordSet.add(s);
      }
      Set<String> visited = new HashSet<>();
      Set<String> beginSet = new HashSet<>();
      Set<String> endSet = new HashSet<>();
      beginSet.add(beginWord);
      endSet.add(endWord);
      visited.add(beginWord);
      int length = 1;
      while (!beginSet.isEmpty() && !endSet.isEmpty()) {
          if (beginSet.size() > endSet.size()) {
              Set<String> tmp = beginSet;
              beginSet = endSet;
              endSet = tmp;
          }
          Set<String> nextLevelSet = new HashSet<>();
          for (String word: beginSet) {
              char[] ch = word.toCharArray();
              for (int i = 0; i < word.length(); i++) {
                  char originChar = ch[i];
                  for (char c = 'a'; c <= 'z'; c++) {
                      if (c == originChar) continue;
                      ch[i] = c;
                      String nextWord = new String(ch);
                      if (wordSet.contains(nextWord)) {
                          if (endSet.contains(nextWord)) {
                              return length + 1;
                          }
                          if (!visited.contains(nextWord)) {
                              visited.add(nextWord);
                              nextLevelSet.add(nextWord);
                          }
                      }
                      ch[i] = originChar;
                  }
              }
          }
          beginSet = nextLevelSet;
          length += 1;
      }
      return 0;
  }
}